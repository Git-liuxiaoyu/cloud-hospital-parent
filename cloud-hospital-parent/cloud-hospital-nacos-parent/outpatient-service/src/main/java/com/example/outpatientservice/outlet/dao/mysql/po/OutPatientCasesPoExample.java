package com.example.outpatientservice.outlet.dao.mysql.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutPatientCasesPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutPatientCasesPoExample() {
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

        public Criteria andDoctoridIsNull() {
            addCriterion("doctorId is null");
            return (Criteria) this;
        }

        public Criteria andDoctoridIsNotNull() {
            addCriterion("doctorId is not null");
            return (Criteria) this;
        }

        public Criteria andDoctoridEqualTo(Long value) {
            addCriterion("doctorId =", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotEqualTo(Long value) {
            addCriterion("doctorId <>", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridGreaterThan(Long value) {
            addCriterion("doctorId >", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridGreaterThanOrEqualTo(Long value) {
            addCriterion("doctorId >=", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridLessThan(Long value) {
            addCriterion("doctorId <", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridLessThanOrEqualTo(Long value) {
            addCriterion("doctorId <=", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridIn(List<Long> values) {
            addCriterion("doctorId in", values, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotIn(List<Long> values) {
            addCriterion("doctorId not in", values, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridBetween(Long value1, Long value2) {
            addCriterion("doctorId between", value1, value2, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotBetween(Long value1, Long value2) {
            addCriterion("doctorId not between", value1, value2, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNull() {
            addCriterion("departmentId is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNotNull() {
            addCriterion("departmentId is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidEqualTo(Long value) {
            addCriterion("departmentId =", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotEqualTo(Long value) {
            addCriterion("departmentId <>", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThan(Long value) {
            addCriterion("departmentId >", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThanOrEqualTo(Long value) {
            addCriterion("departmentId >=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThan(Long value) {
            addCriterion("departmentId <", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThanOrEqualTo(Long value) {
            addCriterion("departmentId <=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIn(List<Long> values) {
            addCriterion("departmentId in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotIn(List<Long> values) {
            addCriterion("departmentId not in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidBetween(Long value1, Long value2) {
            addCriterion("departmentId between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotBetween(Long value1, Long value2) {
            addCriterion("departmentId not between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(String value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(String value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(String value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(String value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(String value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLike(String value) {
            addCriterion("temperature like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotLike(String value) {
            addCriterion("temperature not like", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<String> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<String> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(String value1, String value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(String value1, String value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andPulseIsNull() {
            addCriterion("pulse is null");
            return (Criteria) this;
        }

        public Criteria andPulseIsNotNull() {
            addCriterion("pulse is not null");
            return (Criteria) this;
        }

        public Criteria andPulseEqualTo(String value) {
            addCriterion("pulse =", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseNotEqualTo(String value) {
            addCriterion("pulse <>", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseGreaterThan(String value) {
            addCriterion("pulse >", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseGreaterThanOrEqualTo(String value) {
            addCriterion("pulse >=", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseLessThan(String value) {
            addCriterion("pulse <", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseLessThanOrEqualTo(String value) {
            addCriterion("pulse <=", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseLike(String value) {
            addCriterion("pulse like", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseNotLike(String value) {
            addCriterion("pulse not like", value, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseIn(List<String> values) {
            addCriterion("pulse in", values, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseNotIn(List<String> values) {
            addCriterion("pulse not in", values, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseBetween(String value1, String value2) {
            addCriterion("pulse between", value1, value2, "pulse");
            return (Criteria) this;
        }

        public Criteria andPulseNotBetween(String value1, String value2) {
            addCriterion("pulse not between", value1, value2, "pulse");
            return (Criteria) this;
        }

        public Criteria andBloodIsNull() {
            addCriterion("blood is null");
            return (Criteria) this;
        }

        public Criteria andBloodIsNotNull() {
            addCriterion("blood is not null");
            return (Criteria) this;
        }

        public Criteria andBloodEqualTo(String value) {
            addCriterion("blood =", value, "blood");
            return (Criteria) this;
        }

        public Criteria andBloodNotEqualTo(String value) {
            addCriterion("blood <>", value, "blood");
            return (Criteria) this;
        }

        public Criteria andBloodGreaterThan(String value) {
            addCriterion("blood >", value, "blood");
            return (Criteria) this;
        }

        public Criteria andBloodGreaterThanOrEqualTo(String value) {
            addCriterion("blood >=", value, "blood");
            return (Criteria) this;
        }

        public Criteria andBloodLessThan(String value) {
            addCriterion("blood <", value, "blood");
            return (Criteria) this;
        }

        public Criteria andBloodLessThanOrEqualTo(String value) {
            addCriterion("blood <=", value, "blood");
            return (Criteria) this;
        }

        public Criteria andBloodLike(String value) {
            addCriterion("blood like", value, "blood");
            return (Criteria) this;
        }

        public Criteria andBloodNotLike(String value) {
            addCriterion("blood not like", value, "blood");
            return (Criteria) this;
        }

        public Criteria andBloodIn(List<String> values) {
            addCriterion("blood in", values, "blood");
            return (Criteria) this;
        }

        public Criteria andBloodNotIn(List<String> values) {
            addCriterion("blood not in", values, "blood");
            return (Criteria) this;
        }

        public Criteria andBloodBetween(String value1, String value2) {
            addCriterion("blood between", value1, value2, "blood");
            return (Criteria) this;
        }

        public Criteria andBloodNotBetween(String value1, String value2) {
            addCriterion("blood not between", value1, value2, "blood");
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

        public Criteria andAdviceIsNull() {
            addCriterion("advice is null");
            return (Criteria) this;
        }

        public Criteria andAdviceIsNotNull() {
            addCriterion("advice is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceEqualTo(String value) {
            addCriterion("advice =", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotEqualTo(String value) {
            addCriterion("advice <>", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThan(String value) {
            addCriterion("advice >", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("advice >=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThan(String value) {
            addCriterion("advice <", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThanOrEqualTo(String value) {
            addCriterion("advice <=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLike(String value) {
            addCriterion("advice like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotLike(String value) {
            addCriterion("advice not like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceIn(List<String> values) {
            addCriterion("advice in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotIn(List<String> values) {
            addCriterion("advice not in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceBetween(String value1, String value2) {
            addCriterion("advice between", value1, value2, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotBetween(String value1, String value2) {
            addCriterion("advice not between", value1, value2, "advice");
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

        public Criteria andCheckoddidIsNull() {
            addCriterion("CheckOddId is null");
            return (Criteria) this;
        }

        public Criteria andCheckoddidIsNotNull() {
            addCriterion("CheckOddId is not null");
            return (Criteria) this;
        }

        public Criteria andCheckoddidEqualTo(Long value) {
            addCriterion("CheckOddId =", value, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidNotEqualTo(Long value) {
            addCriterion("CheckOddId <>", value, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidGreaterThan(Long value) {
            addCriterion("CheckOddId >", value, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidGreaterThanOrEqualTo(Long value) {
            addCriterion("CheckOddId >=", value, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidLessThan(Long value) {
            addCriterion("CheckOddId <", value, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidLessThanOrEqualTo(Long value) {
            addCriterion("CheckOddId <=", value, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidIn(List<Long> values) {
            addCriterion("CheckOddId in", values, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidNotIn(List<Long> values) {
            addCriterion("CheckOddId not in", values, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidBetween(Long value1, Long value2) {
            addCriterion("CheckOddId between", value1, value2, "checkoddid");
            return (Criteria) this;
        }

        public Criteria andCheckoddidNotBetween(Long value1, Long value2) {
            addCriterion("CheckOddId not between", value1, value2, "checkoddid");
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

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
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