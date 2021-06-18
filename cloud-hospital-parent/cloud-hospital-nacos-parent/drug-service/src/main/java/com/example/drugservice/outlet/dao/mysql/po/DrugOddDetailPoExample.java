package com.example.drugservice.outlet.dao.mysql.po;

import java.util.ArrayList;
import java.util.List;

public class DrugOddDetailPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrugOddDetailPoExample() {
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

        public Criteria andDrugoddidIsNull() {
            addCriterion("drugoddId is null");
            return (Criteria) this;
        }

        public Criteria andDrugoddidIsNotNull() {
            addCriterion("drugoddId is not null");
            return (Criteria) this;
        }

        public Criteria andDrugoddidEqualTo(Long value) {
            addCriterion("drugoddId =", value, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidNotEqualTo(Long value) {
            addCriterion("drugoddId <>", value, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidGreaterThan(Long value) {
            addCriterion("drugoddId >", value, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidGreaterThanOrEqualTo(Long value) {
            addCriterion("drugoddId >=", value, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidLessThan(Long value) {
            addCriterion("drugoddId <", value, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidLessThanOrEqualTo(Long value) {
            addCriterion("drugoddId <=", value, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidIn(List<Long> values) {
            addCriterion("drugoddId in", values, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidNotIn(List<Long> values) {
            addCriterion("drugoddId not in", values, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidBetween(Long value1, Long value2) {
            addCriterion("drugoddId between", value1, value2, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugoddidNotBetween(Long value1, Long value2) {
            addCriterion("drugoddId not between", value1, value2, "drugoddid");
            return (Criteria) this;
        }

        public Criteria andDrugidIsNull() {
            addCriterion("drugId is null");
            return (Criteria) this;
        }

        public Criteria andDrugidIsNotNull() {
            addCriterion("drugId is not null");
            return (Criteria) this;
        }

        public Criteria andDrugidEqualTo(Integer value) {
            addCriterion("drugId =", value, "drugid");
            return (Criteria) this;
        }

        public Criteria andDrugidNotEqualTo(Integer value) {
            addCriterion("drugId <>", value, "drugid");
            return (Criteria) this;
        }

        public Criteria andDrugidGreaterThan(Integer value) {
            addCriterion("drugId >", value, "drugid");
            return (Criteria) this;
        }

        public Criteria andDrugidGreaterThanOrEqualTo(Integer value) {
            addCriterion("drugId >=", value, "drugid");
            return (Criteria) this;
        }

        public Criteria andDrugidLessThan(Integer value) {
            addCriterion("drugId <", value, "drugid");
            return (Criteria) this;
        }

        public Criteria andDrugidLessThanOrEqualTo(Integer value) {
            addCriterion("drugId <=", value, "drugid");
            return (Criteria) this;
        }

        public Criteria andDrugidIn(List<Integer> values) {
            addCriterion("drugId in", values, "drugid");
            return (Criteria) this;
        }

        public Criteria andDrugidNotIn(List<Integer> values) {
            addCriterion("drugId not in", values, "drugid");
            return (Criteria) this;
        }

        public Criteria andDrugidBetween(Integer value1, Integer value2) {
            addCriterion("drugId between", value1, value2, "drugid");
            return (Criteria) this;
        }

        public Criteria andDrugidNotBetween(Integer value1, Integer value2) {
            addCriterion("drugId not between", value1, value2, "drugid");
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

        public Criteria andDrugnumEqualTo(Long value) {
            addCriterion("drugNum =", value, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumNotEqualTo(Long value) {
            addCriterion("drugNum <>", value, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumGreaterThan(Long value) {
            addCriterion("drugNum >", value, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumGreaterThanOrEqualTo(Long value) {
            addCriterion("drugNum >=", value, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumLessThan(Long value) {
            addCriterion("drugNum <", value, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumLessThanOrEqualTo(Long value) {
            addCriterion("drugNum <=", value, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumIn(List<Long> values) {
            addCriterion("drugNum in", values, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumNotIn(List<Long> values) {
            addCriterion("drugNum not in", values, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumBetween(Long value1, Long value2) {
            addCriterion("drugNum between", value1, value2, "drugnum");
            return (Criteria) this;
        }

        public Criteria andDrugnumNotBetween(Long value1, Long value2) {
            addCriterion("drugNum not between", value1, value2, "drugnum");
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