package com.example.drugservice.outlet.dao.mysql.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrugInstockoddDetailPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugInstockoddDetailPoExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDrugnoIsNull() {
            addCriterion("drugNo is null");
            return (Criteria) this;
        }

        public Criteria andDrugnoIsNotNull() {
            addCriterion("drugNo is not null");
            return (Criteria) this;
        }

        public Criteria andDrugnoEqualTo(String value) {
            addCriterion("drugNo =", value, "drugno");
            return (Criteria) this;
        }

        public Criteria andDrugnoNotEqualTo(String value) {
            addCriterion("drugNo <>", value, "drugno");
            return (Criteria) this;
        }

        public Criteria andDrugnoGreaterThan(String value) {
            addCriterion("drugNo >", value, "drugno");
            return (Criteria) this;
        }

        public Criteria andDrugnoGreaterThanOrEqualTo(String value) {
            addCriterion("drugNo >=", value, "drugno");
            return (Criteria) this;
        }

        public Criteria andDrugnoLessThan(String value) {
            addCriterion("drugNo <", value, "drugno");
            return (Criteria) this;
        }

        public Criteria andDrugnoLessThanOrEqualTo(String value) {
            addCriterion("drugNo <=", value, "drugno");
            return (Criteria) this;
        }

        public Criteria andDrugnoLike(String value) {
            addCriterion("drugNo like", value, "drugno");
            return (Criteria) this;
        }

        public Criteria andDrugnoNotLike(String value) {
            addCriterion("drugNo not like", value, "drugno");
            return (Criteria) this;
        }

        public Criteria andDrugnoIn(List<String> values) {
            addCriterion("drugNo in", values, "drugno");
            return (Criteria) this;
        }

        public Criteria andDrugnoNotIn(List<String> values) {
            addCriterion("drugNo not in", values, "drugno");
            return (Criteria) this;
        }

        public Criteria andDrugnoBetween(String value1, String value2) {
            addCriterion("drugNo between", value1, value2, "drugno");
            return (Criteria) this;
        }

        public Criteria andDrugnoNotBetween(String value1, String value2) {
            addCriterion("drugNo not between", value1, value2, "drugno");
            return (Criteria) this;
        }

        public Criteria andDrugnumIsNull() {
            addCriterion("drugNum is null");
            return (Criteria) this;
        }

        public Criteria andDrugnumIsNotNull() {
            addCriterion("drugNum is not null");
            return (Criteria) this;
        }

        public Criteria andDrugnumEqualTo(Integer value) {
            addCriterion("drugNum =", value, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumNotEqualTo(Integer value) {
            addCriterion("drugNum <>", value, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumGreaterThan(Integer value) {
            addCriterion("drugNum >", value, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("drugNum >=", value, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumLessThan(Integer value) {
            addCriterion("drugNum <", value, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumLessThanOrEqualTo(Integer value) {
            addCriterion("drugNum <=", value, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumIn(List<Integer> values) {
            addCriterion("drugNum in", values, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumNotIn(List<Integer> values) {
            addCriterion("drugNum not in", values, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumBetween(Integer value1, Integer value2) {
            addCriterion("drugNum between", value1, value2, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumNotBetween(Integer value1, Integer value2) {
            addCriterion("drugNum not between", value1, value2, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnameIsNull() {
            addCriterion("drugName is null");
            return (Criteria) this;
        }

        public Criteria andDrugnameIsNotNull() {
            addCriterion("drugName is not null");
            return (Criteria) this;
        }

        public Criteria andDrugnameEqualTo(String value) {
            addCriterion("drugName =", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameNotEqualTo(String value) {
            addCriterion("drugName <>", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameGreaterThan(String value) {
            addCriterion("drugName >", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameGreaterThanOrEqualTo(String value) {
            addCriterion("drugName >=", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameLessThan(String value) {
            addCriterion("drugName <", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameLessThanOrEqualTo(String value) {
            addCriterion("drugName <=", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameLike(String value) {
            addCriterion("drugName like", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameNotLike(String value) {
            addCriterion("drugName not like", value, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameIn(List<String> values) {
            addCriterion("drugName in", values, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameNotIn(List<String> values) {
            addCriterion("drugName not in", values, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameBetween(String value1, String value2) {
            addCriterion("drugName between", value1, value2, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugnameNotBetween(String value1, String value2) {
            addCriterion("drugName not between", value1, value2, "drugname");
            return (Criteria) this;
        }

        public Criteria andDrugtypeidIsNull() {
            addCriterion("drugTypeId is null");
            return (Criteria) this;
        }

        public Criteria andDrugtypeidIsNotNull() {
            addCriterion("drugTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andDrugtypeidEqualTo(Integer value) {
            addCriterion("drugTypeId =", value, "drugtypeid");
            return (Criteria) this;
        }

        public Criteria andDrugtypeidNotEqualTo(Integer value) {
            addCriterion("drugTypeId <>", value, "drugtypeid");
            return (Criteria) this;
        }

        public Criteria andDrugtypeidGreaterThan(Integer value) {
            addCriterion("drugTypeId >", value, "drugtypeid");
            return (Criteria) this;
        }

        public Criteria andDrugtypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("drugTypeId >=", value, "drugtypeid");
            return (Criteria) this;
        }

        public Criteria andDrugtypeidLessThan(Integer value) {
            addCriterion("drugTypeId <", value, "drugtypeid");
            return (Criteria) this;
        }

        public Criteria andDrugtypeidLessThanOrEqualTo(Integer value) {
            addCriterion("drugTypeId <=", value, "drugtypeid");
            return (Criteria) this;
        }

        public Criteria andDrugtypeidIn(List<Integer> values) {
            addCriterion("drugTypeId in", values, "drugtypeid");
            return (Criteria) this;
        }

        public Criteria andDrugtypeidNotIn(List<Integer> values) {
            addCriterion("drugTypeId not in", values, "drugtypeid");
            return (Criteria) this;
        }

        public Criteria andDrugtypeidBetween(Integer value1, Integer value2) {
            addCriterion("drugTypeId between", value1, value2, "drugtypeid");
            return (Criteria) this;
        }

        public Criteria andDrugtypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("drugTypeId not between", value1, value2, "drugtypeid");
            return (Criteria) this;
        }

        public Criteria andDrugcostpriceIsNull() {
            addCriterion("drugCostPrice is null");
            return (Criteria) this;
        }

        public Criteria andDrugcostpriceIsNotNull() {
            addCriterion("drugCostPrice is not null");
            return (Criteria) this;
        }

        public Criteria andDrugcostpriceEqualTo(BigDecimal value) {
            addCriterion("drugCostPrice =", value, "drugcostprice");
            return (Criteria) this;
        }

        public Criteria andDrugcostpriceNotEqualTo(BigDecimal value) {
            addCriterion("drugCostPrice <>", value, "drugcostprice");
            return (Criteria) this;
        }

        public Criteria andDrugcostpriceGreaterThan(BigDecimal value) {
            addCriterion("drugCostPrice >", value, "drugcostprice");
            return (Criteria) this;
        }

        public Criteria andDrugcostpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("drugCostPrice >=", value, "drugcostprice");
            return (Criteria) this;
        }

        public Criteria andDrugcostpriceLessThan(BigDecimal value) {
            addCriterion("drugCostPrice <", value, "drugcostprice");
            return (Criteria) this;
        }

        public Criteria andDrugcostpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("drugCostPrice <=", value, "drugcostprice");
            return (Criteria) this;
        }

        public Criteria andDrugcostpriceIn(List<BigDecimal> values) {
            addCriterion("drugCostPrice in", values, "drugcostprice");
            return (Criteria) this;
        }

        public Criteria andDrugcostpriceNotIn(List<BigDecimal> values) {
            addCriterion("drugCostPrice not in", values, "drugcostprice");
            return (Criteria) this;
        }

        public Criteria andDrugcostpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("drugCostPrice between", value1, value2, "drugcostprice");
            return (Criteria) this;
        }

        public Criteria andDrugcostpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("drugCostPrice not between", value1, value2, "drugcostprice");
            return (Criteria) this;
        }

        public Criteria andDrugsalepriceIsNull() {
            addCriterion("drugSalePrice is null");
            return (Criteria) this;
        }

        public Criteria andDrugsalepriceIsNotNull() {
            addCriterion("drugSalePrice is not null");
            return (Criteria) this;
        }

        public Criteria andDrugsalepriceEqualTo(BigDecimal value) {
            addCriterion("drugSalePrice =", value, "drugsaleprice");
            return (Criteria) this;
        }

        public Criteria andDrugsalepriceNotEqualTo(BigDecimal value) {
            addCriterion("drugSalePrice <>", value, "drugsaleprice");
            return (Criteria) this;
        }

        public Criteria andDrugsalepriceGreaterThan(BigDecimal value) {
            addCriterion("drugSalePrice >", value, "drugsaleprice");
            return (Criteria) this;
        }

        public Criteria andDrugsalepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("drugSalePrice >=", value, "drugsaleprice");
            return (Criteria) this;
        }

        public Criteria andDrugsalepriceLessThan(BigDecimal value) {
            addCriterion("drugSalePrice <", value, "drugsaleprice");
            return (Criteria) this;
        }

        public Criteria andDrugsalepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("drugSalePrice <=", value, "drugsaleprice");
            return (Criteria) this;
        }

        public Criteria andDrugsalepriceIn(List<BigDecimal> values) {
            addCriterion("drugSalePrice in", values, "drugsaleprice");
            return (Criteria) this;
        }

        public Criteria andDrugsalepriceNotIn(List<BigDecimal> values) {
            addCriterion("drugSalePrice not in", values, "drugsaleprice");
            return (Criteria) this;
        }

        public Criteria andDrugsalepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("drugSalePrice between", value1, value2, "drugsaleprice");
            return (Criteria) this;
        }

        public Criteria andDrugsalepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("drugSalePrice not between", value1, value2, "drugsaleprice");
            return (Criteria) this;
        }

        public Criteria andDruglocationIsNull() {
            addCriterion("drugLocation is null");
            return (Criteria) this;
        }

        public Criteria andDruglocationIsNotNull() {
            addCriterion("drugLocation is not null");
            return (Criteria) this;
        }

        public Criteria andDruglocationEqualTo(String value) {
            addCriterion("drugLocation =", value, "druglocation");
            return (Criteria) this;
        }

        public Criteria andDruglocationNotEqualTo(String value) {
            addCriterion("drugLocation <>", value, "druglocation");
            return (Criteria) this;
        }

        public Criteria andDruglocationGreaterThan(String value) {
            addCriterion("drugLocation >", value, "druglocation");
            return (Criteria) this;
        }

        public Criteria andDruglocationGreaterThanOrEqualTo(String value) {
            addCriterion("drugLocation >=", value, "druglocation");
            return (Criteria) this;
        }

        public Criteria andDruglocationLessThan(String value) {
            addCriterion("drugLocation <", value, "druglocation");
            return (Criteria) this;
        }

        public Criteria andDruglocationLessThanOrEqualTo(String value) {
            addCriterion("drugLocation <=", value, "druglocation");
            return (Criteria) this;
        }

        public Criteria andDruglocationLike(String value) {
            addCriterion("drugLocation like", value, "druglocation");
            return (Criteria) this;
        }

        public Criteria andDruglocationNotLike(String value) {
            addCriterion("drugLocation not like", value, "druglocation");
            return (Criteria) this;
        }

        public Criteria andDruglocationIn(List<String> values) {
            addCriterion("drugLocation in", values, "druglocation");
            return (Criteria) this;
        }

        public Criteria andDruglocationNotIn(List<String> values) {
            addCriterion("drugLocation not in", values, "druglocation");
            return (Criteria) this;
        }

        public Criteria andDruglocationBetween(String value1, String value2) {
            addCriterion("drugLocation between", value1, value2, "druglocation");
            return (Criteria) this;
        }

        public Criteria andDruglocationNotBetween(String value1, String value2) {
            addCriterion("drugLocation not between", value1, value2, "druglocation");
            return (Criteria) this;
        }

        public Criteria andDrugproductiontimeIsNull() {
            addCriterion("drugProductionTime is null");
            return (Criteria) this;
        }

        public Criteria andDrugproductiontimeIsNotNull() {
            addCriterion("drugProductionTime is not null");
            return (Criteria) this;
        }

        public Criteria andDrugproductiontimeEqualTo(Date value) {
            addCriterion("drugProductionTime =", value, "drugproductiontime");
            return (Criteria) this;
        }

        public Criteria andDrugproductiontimeNotEqualTo(Date value) {
            addCriterion("drugProductionTime <>", value, "drugproductiontime");
            return (Criteria) this;
        }

        public Criteria andDrugproductiontimeGreaterThan(Date value) {
            addCriterion("drugProductionTime >", value, "drugproductiontime");
            return (Criteria) this;
        }

        public Criteria andDrugproductiontimeGreaterThanOrEqualTo(Date value) {
            addCriterion("drugProductionTime >=", value, "drugproductiontime");
            return (Criteria) this;
        }

        public Criteria andDrugproductiontimeLessThan(Date value) {
            addCriterion("drugProductionTime <", value, "drugproductiontime");
            return (Criteria) this;
        }

        public Criteria andDrugproductiontimeLessThanOrEqualTo(Date value) {
            addCriterion("drugProductionTime <=", value, "drugproductiontime");
            return (Criteria) this;
        }

        public Criteria andDrugproductiontimeIn(List<Date> values) {
            addCriterion("drugProductionTime in", values, "drugproductiontime");
            return (Criteria) this;
        }

        public Criteria andDrugproductiontimeNotIn(List<Date> values) {
            addCriterion("drugProductionTime not in", values, "drugproductiontime");
            return (Criteria) this;
        }

        public Criteria andDrugproductiontimeBetween(Date value1, Date value2) {
            addCriterion("drugProductionTime between", value1, value2, "drugproductiontime");
            return (Criteria) this;
        }

        public Criteria andDrugproductiontimeNotBetween(Date value1, Date value2) {
            addCriterion("drugProductionTime not between", value1, value2, "drugproductiontime");
            return (Criteria) this;
        }

        public Criteria andDrugexpirationtimeIsNull() {
            addCriterion("drugExpirationTime is null");
            return (Criteria) this;
        }

        public Criteria andDrugexpirationtimeIsNotNull() {
            addCriterion("drugExpirationTime is not null");
            return (Criteria) this;
        }

        public Criteria andDrugexpirationtimeEqualTo(Date value) {
            addCriterion("drugExpirationTime =", value, "drugexpirationtime");
            return (Criteria) this;
        }

        public Criteria andDrugexpirationtimeNotEqualTo(Date value) {
            addCriterion("drugExpirationTime <>", value, "drugexpirationtime");
            return (Criteria) this;
        }

        public Criteria andDrugexpirationtimeGreaterThan(Date value) {
            addCriterion("drugExpirationTime >", value, "drugexpirationtime");
            return (Criteria) this;
        }

        public Criteria andDrugexpirationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("drugExpirationTime >=", value, "drugexpirationtime");
            return (Criteria) this;
        }

        public Criteria andDrugexpirationtimeLessThan(Date value) {
            addCriterion("drugExpirationTime <", value, "drugexpirationtime");
            return (Criteria) this;
        }

        public Criteria andDrugexpirationtimeLessThanOrEqualTo(Date value) {
            addCriterion("drugExpirationTime <=", value, "drugexpirationtime");
            return (Criteria) this;
        }

        public Criteria andDrugexpirationtimeIn(List<Date> values) {
            addCriterion("drugExpirationTime in", values, "drugexpirationtime");
            return (Criteria) this;
        }

        public Criteria andDrugexpirationtimeNotIn(List<Date> values) {
            addCriterion("drugExpirationTime not in", values, "drugexpirationtime");
            return (Criteria) this;
        }

        public Criteria andDrugexpirationtimeBetween(Date value1, Date value2) {
            addCriterion("drugExpirationTime between", value1, value2, "drugexpirationtime");
            return (Criteria) this;
        }

        public Criteria andDrugexpirationtimeNotBetween(Date value1, Date value2) {
            addCriterion("drugExpirationTime not between", value1, value2, "drugexpirationtime");
            return (Criteria) this;
        }

        public Criteria andParamIsNull() {
            addCriterion("param is null");
            return (Criteria) this;
        }

        public Criteria andParamIsNotNull() {
            addCriterion("param is not null");
            return (Criteria) this;
        }

        public Criteria andParamEqualTo(String value) {
            addCriterion("param =", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotEqualTo(String value) {
            addCriterion("param <>", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamGreaterThan(String value) {
            addCriterion("param >", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamGreaterThanOrEqualTo(String value) {
            addCriterion("param >=", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLessThan(String value) {
            addCriterion("param <", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLessThanOrEqualTo(String value) {
            addCriterion("param <=", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLike(String value) {
            addCriterion("param like", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotLike(String value) {
            addCriterion("param not like", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamIn(List<String> values) {
            addCriterion("param in", values, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotIn(List<String> values) {
            addCriterion("param not in", values, "param");
            return (Criteria) this;
        }

        public Criteria andParamBetween(String value1, String value2) {
            addCriterion("param between", value1, value2, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotBetween(String value1, String value2) {
            addCriterion("param not between", value1, value2, "param");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}