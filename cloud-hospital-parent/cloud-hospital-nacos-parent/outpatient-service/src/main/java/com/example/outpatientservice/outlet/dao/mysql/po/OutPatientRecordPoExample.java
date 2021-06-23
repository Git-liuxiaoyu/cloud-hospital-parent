package com.example.outpatientservice.outlet.dao.mysql.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutPatientRecordPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutPatientRecordPoExample() {
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

        public Criteria andOutpatientidIsNull() {
            addCriterion("outPatientId is null");
            return (Criteria) this;
        }

        public Criteria andOutpatientidIsNotNull() {
            addCriterion("outPatientId is not null");
            return (Criteria) this;
        }

        public Criteria andOutpatientidEqualTo(Long value) {
            addCriterion("outPatientId =", value, "outpatientid");
            return (Criteria) this;
        }

        public Criteria andOutpatientidNotEqualTo(Long value) {
            addCriterion("outPatientId <>", value, "outpatientid");
            return (Criteria) this;
        }

        public Criteria andOutpatientidGreaterThan(Long value) {
            addCriterion("outPatientId >", value, "outpatientid");
            return (Criteria) this;
        }

        public Criteria andOutpatientidGreaterThanOrEqualTo(Long value) {
            addCriterion("outPatientId >=", value, "outpatientid");
            return (Criteria) this;
        }

        public Criteria andOutpatientidLessThan(Long value) {
            addCriterion("outPatientId <", value, "outpatientid");
            return (Criteria) this;
        }

        public Criteria andOutpatientidLessThanOrEqualTo(Long value) {
            addCriterion("outPatientId <=", value, "outpatientid");
            return (Criteria) this;
        }

        public Criteria andOutpatientidIn(List<Long> values) {
            addCriterion("outPatientId in", values, "outpatientid");
            return (Criteria) this;
        }

        public Criteria andOutpatientidNotIn(List<Long> values) {
            addCriterion("outPatientId not in", values, "outpatientid");
            return (Criteria) this;
        }

        public Criteria andOutpatientidBetween(Long value1, Long value2) {
            addCriterion("outPatientId between", value1, value2, "outpatientid");
            return (Criteria) this;
        }

        public Criteria andOutpatientidNotBetween(Long value1, Long value2) {
            addCriterion("outPatientId not between", value1, value2, "outpatientid");
            return (Criteria) this;
        }

        public Criteria andIscheckIsNull() {
            addCriterion("isCheck is null");
            return (Criteria) this;
        }

        public Criteria andIscheckIsNotNull() {
            addCriterion("isCheck is not null");
            return (Criteria) this;
        }

        public Criteria andIscheckEqualTo(String value) {
            addCriterion("isCheck =", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckNotEqualTo(String value) {
            addCriterion("isCheck <>", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckGreaterThan(String value) {
            addCriterion("isCheck >", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckGreaterThanOrEqualTo(String value) {
            addCriterion("isCheck >=", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckLessThan(String value) {
            addCriterion("isCheck <", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckLessThanOrEqualTo(String value) {
            addCriterion("isCheck <=", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckLike(String value) {
            addCriterion("isCheck like", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckNotLike(String value) {
            addCriterion("isCheck not like", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckIn(List<String> values) {
            addCriterion("isCheck in", values, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckNotIn(List<String> values) {
            addCriterion("isCheck not in", values, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckBetween(String value1, String value2) {
            addCriterion("isCheck between", value1, value2, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckNotBetween(String value1, String value2) {
            addCriterion("isCheck not between", value1, value2, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIsdrugIsNull() {
            addCriterion("isDrug is null");
            return (Criteria) this;
        }

        public Criteria andIsdrugIsNotNull() {
            addCriterion("isDrug is not null");
            return (Criteria) this;
        }

        public Criteria andIsdrugEqualTo(String value) {
            addCriterion("isDrug =", value, "isdrug");
            return (Criteria) this;
        }

        public Criteria andIsdrugNotEqualTo(String value) {
            addCriterion("isDrug <>", value, "isdrug");
            return (Criteria) this;
        }

        public Criteria andIsdrugGreaterThan(String value) {
            addCriterion("isDrug >", value, "isdrug");
            return (Criteria) this;
        }

        public Criteria andIsdrugGreaterThanOrEqualTo(String value) {
            addCriterion("isDrug >=", value, "isdrug");
            return (Criteria) this;
        }

        public Criteria andIsdrugLessThan(String value) {
            addCriterion("isDrug <", value, "isdrug");
            return (Criteria) this;
        }

        public Criteria andIsdrugLessThanOrEqualTo(String value) {
            addCriterion("isDrug <=", value, "isdrug");
            return (Criteria) this;
        }

        public Criteria andIsdrugLike(String value) {
            addCriterion("isDrug like", value, "isdrug");
            return (Criteria) this;
        }

        public Criteria andIsdrugNotLike(String value) {
            addCriterion("isDrug not like", value, "isdrug");
            return (Criteria) this;
        }

        public Criteria andIsdrugIn(List<String> values) {
            addCriterion("isDrug in", values, "isdrug");
            return (Criteria) this;
        }

        public Criteria andIsdrugNotIn(List<String> values) {
            addCriterion("isDrug not in", values, "isdrug");
            return (Criteria) this;
        }

        public Criteria andIsdrugBetween(String value1, String value2) {
            addCriterion("isDrug between", value1, value2, "isdrug");
            return (Criteria) this;
        }

        public Criteria andIsdrugNotBetween(String value1, String value2) {
            addCriterion("isDrug not between", value1, value2, "isdrug");
            return (Criteria) this;
        }

        public Criteria andIshospitalIsNull() {
            addCriterion("isHospital is null");
            return (Criteria) this;
        }

        public Criteria andIshospitalIsNotNull() {
            addCriterion("isHospital is not null");
            return (Criteria) this;
        }

        public Criteria andIshospitalEqualTo(String value) {
            addCriterion("isHospital =", value, "ishospital");
            return (Criteria) this;
        }

        public Criteria andIshospitalNotEqualTo(String value) {
            addCriterion("isHospital <>", value, "ishospital");
            return (Criteria) this;
        }

        public Criteria andIshospitalGreaterThan(String value) {
            addCriterion("isHospital >", value, "ishospital");
            return (Criteria) this;
        }

        public Criteria andIshospitalGreaterThanOrEqualTo(String value) {
            addCriterion("isHospital >=", value, "ishospital");
            return (Criteria) this;
        }

        public Criteria andIshospitalLessThan(String value) {
            addCriterion("isHospital <", value, "ishospital");
            return (Criteria) this;
        }

        public Criteria andIshospitalLessThanOrEqualTo(String value) {
            addCriterion("isHospital <=", value, "ishospital");
            return (Criteria) this;
        }

        public Criteria andIshospitalLike(String value) {
            addCriterion("isHospital like", value, "ishospital");
            return (Criteria) this;
        }

        public Criteria andIshospitalNotLike(String value) {
            addCriterion("isHospital not like", value, "ishospital");
            return (Criteria) this;
        }

        public Criteria andIshospitalIn(List<String> values) {
            addCriterion("isHospital in", values, "ishospital");
            return (Criteria) this;
        }

        public Criteria andIshospitalNotIn(List<String> values) {
            addCriterion("isHospital not in", values, "ishospital");
            return (Criteria) this;
        }

        public Criteria andIshospitalBetween(String value1, String value2) {
            addCriterion("isHospital between", value1, value2, "ishospital");
            return (Criteria) this;
        }

        public Criteria andIshospitalNotBetween(String value1, String value2) {
            addCriterion("isHospital not between", value1, value2, "ishospital");
            return (Criteria) this;
        }

        public Criteria andIsoperationIsNull() {
            addCriterion("isOperation is null");
            return (Criteria) this;
        }

        public Criteria andIsoperationIsNotNull() {
            addCriterion("isOperation is not null");
            return (Criteria) this;
        }

        public Criteria andIsoperationEqualTo(String value) {
            addCriterion("isOperation =", value, "isoperation");
            return (Criteria) this;
        }

        public Criteria andIsoperationNotEqualTo(String value) {
            addCriterion("isOperation <>", value, "isoperation");
            return (Criteria) this;
        }

        public Criteria andIsoperationGreaterThan(String value) {
            addCriterion("isOperation >", value, "isoperation");
            return (Criteria) this;
        }

        public Criteria andIsoperationGreaterThanOrEqualTo(String value) {
            addCriterion("isOperation >=", value, "isoperation");
            return (Criteria) this;
        }

        public Criteria andIsoperationLessThan(String value) {
            addCriterion("isOperation <", value, "isoperation");
            return (Criteria) this;
        }

        public Criteria andIsoperationLessThanOrEqualTo(String value) {
            addCriterion("isOperation <=", value, "isoperation");
            return (Criteria) this;
        }

        public Criteria andIsoperationLike(String value) {
            addCriterion("isOperation like", value, "isoperation");
            return (Criteria) this;
        }

        public Criteria andIsoperationNotLike(String value) {
            addCriterion("isOperation not like", value, "isoperation");
            return (Criteria) this;
        }

        public Criteria andIsoperationIn(List<String> values) {
            addCriterion("isOperation in", values, "isoperation");
            return (Criteria) this;
        }

        public Criteria andIsoperationNotIn(List<String> values) {
            addCriterion("isOperation not in", values, "isoperation");
            return (Criteria) this;
        }

        public Criteria andIsoperationBetween(String value1, String value2) {
            addCriterion("isOperation between", value1, value2, "isoperation");
            return (Criteria) this;
        }

        public Criteria andIsoperationNotBetween(String value1, String value2) {
            addCriterion("isOperation not between", value1, value2, "isoperation");
            return (Criteria) this;
        }

        public Criteria andCheckoddidIsNull() {
            addCriterion("checkOddId is null");
            return (Criteria) this;
        }

        public Criteria andCheckoddidIsNotNull() {
            addCriterion("checkOddId is not null");
            return (Criteria) this;
        }

        public Criteria andCheckoddidEqualTo(Long value) {
            addCriterion("checkOddId =", value, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidNotEqualTo(Long value) {
            addCriterion("checkOddId <>", value, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidGreaterThan(Long value) {
            addCriterion("checkOddId >", value, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidGreaterThanOrEqualTo(Long value) {
            addCriterion("checkOddId >=", value, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidLessThan(Long value) {
            addCriterion("checkOddId <", value, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidLessThanOrEqualTo(Long value) {
            addCriterion("checkOddId <=", value, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidIn(List<Long> values) {
            addCriterion("checkOddId in", values, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidNotIn(List<Long> values) {
            addCriterion("checkOddId not in", values, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidBetween(Long value1, Long value2) {
            addCriterion("checkOddId between", value1, value2, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidNotBetween(Long value1, Long value2) {
            addCriterion("checkOddId not between", value1, value2, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidIsNull() {
            addCriterion("drugOddId is null");
            return (Criteria) this;
        }

        public Criteria andDrugoddidIsNotNull() {
            addCriterion("drugOddId is not null");
            return (Criteria) this;
        }

        public Criteria andDrugoddidEqualTo(Long value) {
            addCriterion("drugOddId =", value, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidNotEqualTo(Long value) {
            addCriterion("drugOddId <>", value, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidGreaterThan(Long value) {
            addCriterion("drugOddId >", value, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidGreaterThanOrEqualTo(Long value) {
            addCriterion("drugOddId >=", value, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidLessThan(Long value) {
            addCriterion("drugOddId <", value, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidLessThanOrEqualTo(Long value) {
            addCriterion("drugOddId <=", value, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidIn(List<Long> values) {
            addCriterion("drugOddId in", values, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidNotIn(List<Long> values) {
            addCriterion("drugOddId not in", values, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidBetween(Long value1, Long value2) {
            addCriterion("drugOddId between", value1, value2, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidNotBetween(Long value1, Long value2) {
            addCriterion("drugOddId not between", value1, value2, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andHospitaloddidIsNull() {
            addCriterion("hospitalOddId is null");
            return (Criteria) this;
        }

        public Criteria andHospitaloddidIsNotNull() {
            addCriterion("hospitalOddId is not null");
            return (Criteria) this;
        }

        public Criteria andHospitaloddidEqualTo(Long value) {
            addCriterion("hospitalOddId =", value, "hospitaloddid");
            return (Criteria) this;
        }

        public Criteria andHospitaloddidNotEqualTo(Long value) {
            addCriterion("hospitalOddId <>", value, "hospitaloddid");
            return (Criteria) this;
        }

        public Criteria andHospitaloddidGreaterThan(Long value) {
            addCriterion("hospitalOddId >", value, "hospitaloddid");
            return (Criteria) this;
        }

        public Criteria andHospitaloddidGreaterThanOrEqualTo(Long value) {
            addCriterion("hospitalOddId >=", value, "hospitaloddid");
            return (Criteria) this;
        }

        public Criteria andHospitaloddidLessThan(Long value) {
            addCriterion("hospitalOddId <", value, "hospitaloddid");
            return (Criteria) this;
        }

        public Criteria andHospitaloddidLessThanOrEqualTo(Long value) {
            addCriterion("hospitalOddId <=", value, "hospitaloddid");
            return (Criteria) this;
        }

        public Criteria andHospitaloddidIn(List<Long> values) {
            addCriterion("hospitalOddId in", values, "hospitaloddid");
            return (Criteria) this;
        }

        public Criteria andHospitaloddidNotIn(List<Long> values) {
            addCriterion("hospitalOddId not in", values, "hospitaloddid");
            return (Criteria) this;
        }

        public Criteria andHospitaloddidBetween(Long value1, Long value2) {
            addCriterion("hospitalOddId between", value1, value2, "hospitaloddid");
            return (Criteria) this;
        }

        public Criteria andHospitaloddidNotBetween(Long value1, Long value2) {
            addCriterion("hospitalOddId not between", value1, value2, "hospitaloddid");
            return (Criteria) this;
        }

        public Criteria andOperationoddidIsNull() {
            addCriterion("operationOddId is null");
            return (Criteria) this;
        }

        public Criteria andOperationoddidIsNotNull() {
            addCriterion("operationOddId is not null");
            return (Criteria) this;
        }

        public Criteria andOperationoddidEqualTo(Integer value) {
            addCriterion("operationOddId =", value, "operationoddid");
            return (Criteria) this;
        }

        public Criteria andOperationoddidNotEqualTo(Integer value) {
            addCriterion("operationOddId <>", value, "operationoddid");
            return (Criteria) this;
        }

        public Criteria andOperationoddidGreaterThan(Integer value) {
            addCriterion("operationOddId >", value, "operationoddid");
            return (Criteria) this;
        }

        public Criteria andOperationoddidGreaterThanOrEqualTo(Integer value) {
            addCriterion("operationOddId >=", value, "operationoddid");
            return (Criteria) this;
        }

        public Criteria andOperationoddidLessThan(Integer value) {
            addCriterion("operationOddId <", value, "operationoddid");
            return (Criteria) this;
        }

        public Criteria andOperationoddidLessThanOrEqualTo(Integer value) {
            addCriterion("operationOddId <=", value, "operationoddid");
            return (Criteria) this;
        }

        public Criteria andOperationoddidIn(List<Integer> values) {
            addCriterion("operationOddId in", values, "operationoddid");
            return (Criteria) this;
        }

        public Criteria andOperationoddidNotIn(List<Integer> values) {
            addCriterion("operationOddId not in", values, "operationoddid");
            return (Criteria) this;
        }

        public Criteria andOperationoddidBetween(Integer value1, Integer value2) {
            addCriterion("operationOddId between", value1, value2, "operationoddid");
            return (Criteria) this;
        }

        public Criteria andOperationoddidNotBetween(Integer value1, Integer value2) {
            addCriterion("operationOddId not between", value1, value2, "operationoddid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andParam1IsNull() {
            addCriterion("param1 is null");
            return (Criteria) this;
        }

        public Criteria andParam1IsNotNull() {
            addCriterion("param1 is not null");
            return (Criteria) this;
        }

        public Criteria andParam1EqualTo(String value) {
            addCriterion("param1 =", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotEqualTo(String value) {
            addCriterion("param1 <>", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1GreaterThan(String value) {
            addCriterion("param1 >", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1GreaterThanOrEqualTo(String value) {
            addCriterion("param1 >=", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1LessThan(String value) {
            addCriterion("param1 <", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1LessThanOrEqualTo(String value) {
            addCriterion("param1 <=", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1Like(String value) {
            addCriterion("param1 like", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotLike(String value) {
            addCriterion("param1 not like", value, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1In(List<String> values) {
            addCriterion("param1 in", values, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotIn(List<String> values) {
            addCriterion("param1 not in", values, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1Between(String value1, String value2) {
            addCriterion("param1 between", value1, value2, "param1");
            return (Criteria) this;
        }

        public Criteria andParam1NotBetween(String value1, String value2) {
            addCriterion("param1 not between", value1, value2, "param1");
            return (Criteria) this;
        }

        public Criteria andParam2IsNull() {
            addCriterion("param2 is null");
            return (Criteria) this;
        }

        public Criteria andParam2IsNotNull() {
            addCriterion("param2 is not null");
            return (Criteria) this;
        }

        public Criteria andParam2EqualTo(Long value) {
            addCriterion("param2 =", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotEqualTo(Long value) {
            addCriterion("param2 <>", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2GreaterThan(Long value) {
            addCriterion("param2 >", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2GreaterThanOrEqualTo(Long value) {
            addCriterion("param2 >=", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2LessThan(Long value) {
            addCriterion("param2 <", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2LessThanOrEqualTo(Long value) {
            addCriterion("param2 <=", value, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2In(List<Long> values) {
            addCriterion("param2 in", values, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotIn(List<Long> values) {
            addCriterion("param2 not in", values, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2Between(Long value1, Long value2) {
            addCriterion("param2 between", value1, value2, "param2");
            return (Criteria) this;
        }

        public Criteria andParam2NotBetween(Long value1, Long value2) {
            addCriterion("param2 not between", value1, value2, "param2");
            return (Criteria) this;
        }

        public Criteria andParam3IsNull() {
            addCriterion("param3 is null");
            return (Criteria) this;
        }

        public Criteria andParam3IsNotNull() {
            addCriterion("param3 is not null");
            return (Criteria) this;
        }

        public Criteria andParam3EqualTo(String value) {
            addCriterion("param3 =", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotEqualTo(String value) {
            addCriterion("param3 <>", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3GreaterThan(String value) {
            addCriterion("param3 >", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3GreaterThanOrEqualTo(String value) {
            addCriterion("param3 >=", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3LessThan(String value) {
            addCriterion("param3 <", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3LessThanOrEqualTo(String value) {
            addCriterion("param3 <=", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3Like(String value) {
            addCriterion("param3 like", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotLike(String value) {
            addCriterion("param3 not like", value, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3In(List<String> values) {
            addCriterion("param3 in", values, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotIn(List<String> values) {
            addCriterion("param3 not in", values, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3Between(String value1, String value2) {
            addCriterion("param3 between", value1, value2, "param3");
            return (Criteria) this;
        }

        public Criteria andParam3NotBetween(String value1, String value2) {
            addCriterion("param3 not between", value1, value2, "param3");
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