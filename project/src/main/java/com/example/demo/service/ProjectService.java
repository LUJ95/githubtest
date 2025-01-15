package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ProjectDAO;
import com.example.demo.dto.CompanyVO;
import com.example.demo.dto.FileVO;
import com.example.demo.dto.InventoryMaterialVO;
import com.example.demo.dto.MaterialVO;
import com.example.demo.dto.MemberVO;
import com.example.demo.dto.OrderformDetailVO;
import com.example.demo.dto.OrderformVO;
import com.example.demo.dto.PlandetailVO;
import com.example.demo.dto.ProductVO;
import com.example.demo.dto.ProductionPlanVO;
import com.example.demo.dto.QcVO;
import com.example.demo.dto.QuotationDetailVO;
import com.example.demo.dto.QuotationVO;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectService {
	
	private ModelAndView mv;

	@Autowired
	private ProjectDAO projectDAO;
	

	public ModelAndView getLogin() {
	       mv = new ModelAndView();
	       mv.setViewName("login");
	       return mv;
	   }
	
	// 로그인
    public ModelAndView postLogin(@RequestParam Map<String,Object> map,HttpSession session) {
    	mv = new ModelAndView();
    	MemberVO member = projectDAO.getMember(map);
    	
    	if (member == null) {
    		mv.addObject("msg", "로그인에 실패하였습니다.");
    		mv.setViewName("login");
    		return mv;
    	}
    	 
    	session.setAttribute("user", member); 
        mv.setViewName("index");
    	
    	return mv;
    }
    
    
    public ModelAndView getLogout(HttpSession session) {
    	mv = new ModelAndView();
    	session.invalidate();
    	mv.setViewName("login");
    	return mv;
    }
	
    // 회원가입
    public ModelAndView postRegister(Map<String,Object> map) {
    	mv = new ModelAndView();
    	int r = projectDAO.postRegister(map);
    	
    	if (r == 1) {
    		mv.addObject("msg", "회원가입 성공");
    		mv.setViewName("login");
    		return mv;
    	} 
    	
    	mv.addObject("msg", "회원가입 실패. 다시 진행해주세요.");
    	mv.setViewName("register");
    	return mv;
    }
    
    public boolean isMember_idTaken(String member_id) {
    	return projectDAO.checkMember_id(member_id) > 0;
    }
    
    
    
    
	
	public List<OrderformVO> orderformList() {
		return projectDAO.orderformList();
	}
	
	public int addCompany(CompanyVO companyVO) {
		return projectDAO.addCompany(companyVO);
	}
	public int addProduct(ProductVO productVO) {
		return projectDAO.addProduct(productVO);
	}
	public int findMaxProductNum() {
		return projectDAO.findMaxProductNum();
	}
	public int fileUpload(FileVO fileVO) {
		return projectDAO.fileUpload(fileVO);
	}
	public int productCodeCheck(String product_code) {
		return projectDAO.productCodeCheck(product_code);
	}
	public String companyNameCheck(String company_name) {
		return projectDAO.companyNameCheck(company_name);
	}
	
	
	public List<OrderformVO> orderList(){
		log.info("orderList()");
		return projectDAO.orderList();
	}
	public List<QuotationVO> quotationList(){
		log.info("quotationList()");
		return projectDAO.quotationList();
	}
	public List<QuotationVO> allFormList(){
		log.info("allFormList()");
		return projectDAO.allFormList();
	}
	
	
	// 구매계약서 등록 화면 이동
    public ModelAndView getOrderformRegister() throws Exception {
    	mv = new ModelAndView();
    	List<CompanyVO> companies = projectDAO.getCompanyList();
    	List<MaterialVO> products = projectDAO.getMaterialList();
    	String productsJson = new ObjectMapper().writeValueAsString(products);
    	mv.addObject("products", products);
    	mv.addObject("productsJson", productsJson);
    	mv.addObject("companies", companies);
    	mv.setViewName("orderformRegister");
    	
    	return mv;	
    }
    
    // 구매계약서 등록
    public ModelAndView postOrderformRegister(Map<String,Object> map) throws Exception {
    	mv = new ModelAndView();
    	CompanyVO company1 = projectDAO.getCompanyByCompanyName((String)map.get("company1"));
    	CompanyVO company2 = projectDAO.getCompanyByCompanyName((String)map.get("company2"));
    	
    	System.out.println(map);
    	OrderformVO orderformVO = new OrderformVO();
    	orderformVO.setOrderform_name((String)map.get("orderform_name"));
    	orderformVO.setOrderform_stat((String)map.get("orderform_stat"));
    	orderformVO.setCompany_num(company1.getCompany_num());
    	orderformVO.setCompany_num2(company2.getCompany_num());
    	orderformVO.setOrderform_content((String)map.get("content"));
    	orderformVO.setOrderform_startDate((String)map.get("start_date"));
    	orderformVO.setOrderform_endDate((String)map.get("end_date"));
    	
    	int r = projectDAO.insertOrderform(orderformVO);
    	
    	int OrderformLastNum = projectDAO.getLastOrderformNum();
    	
    	Map<String,Object> itemData = map.entrySet()
    			.stream()
    			.filter(entry -> entry.getKey().contains("item"))
    			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    	
    	Optional<Integer> itemMaxNumber = itemData.keySet()
    			.stream()
    			.filter(key -> key.startsWith("item"))
    			.map(key -> Integer.parseInt(key.replace("item", "")))
    			.max(Integer::compareTo);
    	
    	int itemMaxNumberint = itemMaxNumber.orElse(0);
    	
    	OrderformDetailVO orderformDetailVO = new OrderformDetailVO();
    	InventoryMaterialVO inventoryMaterialVO = new InventoryMaterialVO();
    	
    	for(int i=1; i <= itemMaxNumberint; i++) {
    		String itemkey = "item" + i;
    		String itemvalue = (String)map.get(itemkey);
    		MaterialVO materialVO = projectDAO.getMaterialByMaterialName(itemvalue);
    		int material_num = materialVO.getMaterial_num();
    		
    		String amountkey = "quantity" + i;
    		String amountvalue = (String)map.get(amountkey);
    		int amountvalueInt = Integer.parseInt(amountvalue);
    		
    		String pricekey = "total_price" + i;
    		String pricevalue = (String)map.get(pricekey);
    		int pricevalueInt = Integer.parseInt(pricevalue);
    		orderformDetailVO.setOrderform_num(OrderformLastNum);
	    	orderformDetailVO.setProduct_num(material_num);
	    	orderformDetailVO.setOrderdetail_amount(amountvalueInt);
	    	orderformDetailVO.setOrderdetail_price(pricevalueInt);
	    	
	    	int result = projectDAO.insertOrderformDetail(orderformDetailVO);
    	}
    	
    	
    	
    	inventoryMaterialVO.setInvenmat_name(null);
    	
    	
    	mv.addObject("msg", "계약서 등록 완료");
    	mv.setViewName("purchaseContract");
    	return mv;
    }
    
    
    // 판매계약서 등록 화면 이동
    public ModelAndView getQuotationRegister() throws Exception {
    	
    	mv = new ModelAndView();
    	List<CompanyVO> companies = projectDAO.getCompanyList();
    	List<ProductVO> products = projectDAO.getProductList();
    	String productsJson = new ObjectMapper().writeValueAsString(products);
    	mv.addObject("products", products);
    	mv.addObject("productsJson", productsJson);
    	mv.addObject("companies", companies);
    	mv.setViewName("quotationRegister");
    	return mv;
    }
    
	// 판매계약서 등록
	public ModelAndView postQuotationRegister(Map<String,Object> map) throws Exception {
    	mv = new ModelAndView();
    	CompanyVO company1 = projectDAO.getCompanyByCompanyName((String)map.get("company1"));
    	CompanyVO company2 = projectDAO.getCompanyByCompanyName((String)map.get("company2"));
    	
    	QuotationVO quotationVO = new QuotationVO();
    	quotationVO.setQuot_name((String)map.get("quot_name"));
    	quotationVO.setQuot_stat((String)map.get("quot_stat"));
    	quotationVO.setCompany_num(company1.getCompany_num());
    	quotationVO.setCompany_num2(company2.getCompany_num());
    	quotationVO.setQuot_content((String)map.get("content"));
    	quotationVO.setQuot_startdate((String)map.get("start_date"));
    	quotationVO.setQuot_enddate((String)map.get("end_date"));
    	
    	int r = projectDAO.insertQuotation(quotationVO);
    	
    	int QuotationLastNum = projectDAO.getLastQuotationNum();
    	
    	Map<String,Object> itemData = map.entrySet()
    			.stream()
    			.filter(entry -> entry.getKey().contains("item"))
    			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    	
    	Optional<Integer> itemMaxNumber = itemData.keySet()
    			.stream()
    			.filter(key -> key.startsWith("item"))
    			.map(key -> Integer.parseInt(key.replace("item", "")))
    			.max(Integer::compareTo);
    	
    	int itemMaxNumberint = itemMaxNumber.orElse(0);
    	
    	QuotationDetailVO quotationDetailVO = new QuotationDetailVO();
    	
    	for (int i=1; i<= itemMaxNumberint; i++) {
    		String itemkey = "item" + i;
    		String itemvalue = (String)map.get(itemkey);
    		ProductVO productVO = projectDAO.getProductByProductName(itemvalue);
    		int product_num = productVO.getProduct_num();
    		
    		String amountkey = "quantity" + i;
    		String amountvalue = (String)map.get(amountkey);
    		int amountvalueInt = Integer.parseInt(amountvalue);
    		
    		String pricekey = "total_price" + i;
    		String pricevalue = (String)map.get(pricekey);
    		int pricevalueInt = Integer.parseInt(pricevalue);
    		quotationDetailVO.setQuot_num(QuotationLastNum);
    		quotationDetailVO.setProduct_num(product_num);
    		quotationDetailVO.setQuotdetail_amount(amountvalueInt);
    		quotationDetailVO.setQuotdetail_price(pricevalueInt);
    		
    		int result = projectDAO.insertQuotationDetail(quotationDetailVO);
    	}
    	
    	mv.setViewName("quotationDetail");
    	return mv;
    }
        
        
	public CompanyVO getCompanyByCompanyName(String company_name) {
		return projectDAO.getCompanyByCompanyName(company_name);
	}
  
	public ProductVO getProductByProductName(String product_name) {
		return projectDAO.getProductByProductName(product_name);
	}

// 나현
// QC

	// QC 전체 리스트 입력	
	public List<QcVO> getQcList() {
		return projectDAO.getQcList();
	}
	
	// QC 1건 정보
	public ModelAndView getOneQc(int qc_num) {
		log.info("getOneQcDetail - ProjectService");
		mv = new ModelAndView();
		QcVO qc = projectDAO.getOneQc(qc_num);
		mv.addObject("qc", qc);
		return mv;
	}
	
	// QC 1건 질문 - 응답 정보
	public ModelAndView getOneQcDetail(int qc_num) {
		mv = new ModelAndView();
		List<QcVO> qcDetail = projectDAO.getOneQcDetail(qc_num);
		mv.addObject("qcDetail", qcDetail);
		return mv;
	}

	public List<ProductionPlanVO> getProductionPlanList() {
		// TODO Auto-generated method stub
		log.info("getProductionPlanList()");
		return projectDAO.getProductionPlanList();
	}
	
	public int setproductionForm(List<PlandetailVO> list) {
		// TODO Auto-generated method stub
		return projectDAO.insertPlandetail(list);
	}

	public int insertProduction(ProductionPlanVO productionPlanVO) {
		// TODO Auto-generated method stub
		return projectDAO.insertProduction(productionPlanVO);
	}

	public int getfindLastProductionNumber() {
		// TODO Auto-generated method stub
		return projectDAO.getfindLastProductionNumber();
	}

	// -----------------------------------------------------------------------------

	public int companyNameValidation(String company_name) {
		return projectDAO.companyNameValidation(company_name);
	}
	public int companyCodeValidation(String company_code) {
		return projectDAO.companyCodeValidation(company_code);
	}

	public List<ProductVO> productList() {
		return projectDAO.productList();
	}
	
	
	public int fileAmount(int product_num) {
		return projectDAO.fileAmount(product_num);
	}
	
	public FileVO findFirstImage(int product_num) {
		return projectDAO.findFirstImage(product_num);
	}
	
	public ProductVO getProductDetail (int product_num) {
		return projectDAO.getProductDetail(product_num);
	}

	public List<FileVO> getProductImages(int product_num) {
		return projectDAO.getProductImages(product_num);
	}
	
	public List<CompanyVO> getCompanyList() {
		return projectDAO.getCompanyList();
	}
	
	public List<ProductVO> getProductList() {
		return projectDAO.getProductList();
	}
	


// ---------------new 작업공간 (이의재) ----------------------------
	
	public ModelAndView getQuotationDetail(
			@RequestParam("quot_num") int quot_num
			) {
		
		QuotationVO quotationVO = new QuotationVO();
		quotationVO = projectDAO.getQuotationByQuotnum(quot_num);
		List<QuotationDetailVO> quotationDetailListVO = projectDAO.getQuotationDetailListByQuotnum(quot_num);
		
		CompanyVO company1VO = projectDAO.getCompanyByCompanynum(quotationVO.getCompany_num());
		CompanyVO company2VO = projectDAO.getCompanyByCompanynum(quotationVO.getCompany_num2());
		
		String code = updateQuotationCode(quotationVO);
		
		
		mv = new ModelAndView();
		mv.addObject("code", code);
		mv.addObject("quotationDetailListVO", quotationDetailListVO);
		mv.addObject("company1VO", company1VO);
		mv.addObject("company2VO", company2VO);
		mv.addObject("quotationVO", quotationVO);
		mv.setViewName("quotationDetail");
		return mv;
	}
	
	public ModelAndView getOrderformDetail(
			@RequestParam("orderform_num") int orderform_num
			) {
		OrderformVO orderformVO = new OrderformVO();
		orderformVO = projectDAO.getOrderformByOrderformnum(orderform_num);
		List<OrderformDetailVO> orderformDetailListVO = projectDAO.getOrderformDetailListByOrderformnum(orderform_num);
		
		CompanyVO company1VO = projectDAO.getCompanyByCompanynum(orderformVO.getCompany_num());
		CompanyVO company2VO = projectDAO.getCompanyByCompanynum(orderformVO.getCompany_num2());
		
		String code = updateOrderformCode(orderformVO);
		
		mv = new ModelAndView();
		mv.addObject("code", code);
		mv.addObject("orderformDetailListVO", orderformDetailListVO);
		mv.addObject("company1VO", company1VO);
		mv.addObject("company2VO", company2VO);
		mv.addObject("orderformVO", orderformVO);
		mv.setViewName("orderformDetail");
		return mv;
	}

	public String updateQuotationCode(QuotationVO quotationVO) {
		String code1 = quotationVO.getQuot_regdate().substring(0,10).replaceAll("-", "");
		String code2 = Integer.toString(quotationVO.getCompany_num());
		String code3 = Integer.toString(quotationVO.getCompany_num2());
		String code4 = Integer.toString(quotationVO.getQuot_num());
		String code = code1 + code2 + code3 + code4;
		return code;
	}
	
	public String updateOrderformCode(OrderformVO orderformVO) {
		String code1 = orderformVO.getOrderform_regdate().substring(0,10).replaceAll("-", "");
		String code2 = Integer.toString(orderformVO.getCompany_num());
		String code3 = Integer.toString(orderformVO.getCompany_num2());
		String code4 = Integer.toString(orderformVO.getOrderform_num());
		String code = code1 + code2 + code3 + code4;
		return code;
	}
	
	public ModelAndView getAllFormDetail(
			@RequestParam("this_num") String this_num
			) {
		mv = new ModelAndView();
		if (this_num.contains("quot")) {
			int quot_num = Integer.parseInt(this_num.replaceAll("quot", ""));
			mv.addObject("quot_num", quot_num);
			mv.setViewName("getQuotationDetail");
			return mv;
		}
		return mv;
	}
	
	public ModelAndView getMaterialRegister() {
		mv = new ModelAndView();
		mv.setViewName("materialRegister");
		return mv;
	}
	
	public int materialCodeCheck(String material_code) {
		return projectDAO.materialCodeCheck(material_code);
	}
	
	public int findMaxMaterialNum() {
		return projectDAO.findMaxMaterialNum();
	}
	
	public int addMaterial(MaterialVO materialVO) {
		return projectDAO.addMaterial(materialVO);
	}
	
	public List<MaterialVO> getMaterialList() {
		return projectDAO.getMaterialList();
	}
	
	public int materialFileAmount(int material_num) {
		return projectDAO.materialFileAmount(material_num);
	}
	
	public FileVO materialFindFirstImage(int material_num) {
		return projectDAO.materialFindFirstImage(material_num);
	}

	public List<FileVO> getMaterialImages(int material_num) {
		return projectDAO.getMaterialImages(material_num);
	}
	
	public MaterialVO getMaterialDetail (int material_num) {
		return projectDAO.getMaterialDetail(material_num);
	}
	
	public MaterialVO getMaterialByMaterialName(String product_name) {
		return projectDAO.getMaterialByMaterialName(product_name);
	}
}
