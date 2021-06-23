package com.example.workerservice.outlet.dao.mysql.po;

import java.util.ArrayList;
import java.util.List;

public class PositionPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PositionPoExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andIsoutIsNull() {
            addCriterion("isOut is null");
            return (Criteria) this;
        }

        public Criteria andIsoutIsNotNull() {
            addCriterion("isOut is not null");
            return (Criteria) this;
        }

        public Criteria andIsoutEqualTo(String value) {
            addCriterion("isOut =", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutNotEqualTo(String value) {
            addCriterion("isOut <>", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutGreaterThan(String value) {
            addCriterion("isOut >", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutGreaterThanOrEqualTo(String value) {
            addCriterion("isOut >=", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutLessThan(String value) {
            addCriterion("isOut <", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutLessThanOrEqualTo(String value) {
            addCriterion("isOut <=", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutLike(String value) {
            addCriterion("isOut like", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutNotLike(String value) {
            addCriterion("isOut not like", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutIn(List<String> values) {
            addCriterion("isOut in", values, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutNotIn(List<String> values) {
            addCriterion("isOut not in", values, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutBetween(String value1, String value2) {
            addCriterion("isOut between", value1, value2, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutNotBetween(String value1, String value2) {
            addCriterion("isOut not between", value1, value2, "isout");
            return (Criteria) this;
        }

        public Criteria andIsinIsNull() {
            addCriterion("isIn is null");
            return (Criteria) this;
        }

        public Criteria andIsinIsNotNull() {
            addCriterion("isIn is not null");
            return (Criteria) this;
        }

        public Criteria andIsinEqualTo(String value) {
            addCriterion("isIn =", value, "isin");
            return (Criteria) this;
        }

        public Criteria andIsinNotEqualTo(String value) {
            addCriterion("isIn <>", value, "isin");
            return (Criteria) this;
        }

        public Criteria andIsinGreaterThan(String value) {
            addCriterion("isIn >", value, "isin");
            return (Criteria) this;
        }

        public Criteria andIsinGreaterThanOrEqualTo(String value) {
            addCriterion("isIn >=", value, "isin");
            return (Criteria) this;
        }

        public Criteria andIsinLessThan(String value) {
            addCriterion("isIn <", value, "isin");
            return (Criteria) this;
        }

        public Criteria andIsinLessThanOrEqualTo(String value) {
            addCriterion("isIn <=", value, "isin");
            return (Criteria) this;
        }

        public Criteria andIsinLike(String value) {
            addCriterion("isIn like", value, "isin");
            return (Criteria) this;
        }

        public Criteria andIsinNotLike(String value) {
            addCriterion("isIn not like", value, "isin");
            return (Criteria) this;
        }

        public Criteria andIsinIn(List<String> values) {
            addCriterion("isIn in", values, "isin");
            return (Criteria) this;
        }

        public Criteria andIsinNotIn(List<String> values) {
            addCriterion("isIn not in", values, "isin");
            return (Criteria) this;
        }

        public Criteria andIsinBetween(String value1, String value2) {
            addCriterion("isIn between", value1, value2, "isin");
            return (Criteria) this;
        }

        public Criteria andIsinNotBetween(String value1, String value2) {
            addCriterion("isIn not between", value1, value2, "isin");
            return (Criteria) this;
        }

        public Criteria andIsmdcIsNull() {
            addCriterion("isMdc is null");
            return (Criteria) this;
        }

        public Criteria andIsmdcIsNotNull() {
            addCriterion("isMdc is not null");
            return (Criteria) this;
        }

        public Criteria andIsmdcEqualTo(String value) {
            addCriterion("isMdc =", value, "ismdc");
            return (Criteria) this;
        }

        public Criteria andIsmdcNotEqualTo(String value) {
            addCriterion("isMdc <>", value, "ismdc");
            return (Criteria) this;
        }

        public Criteria andIsmdcGreaterThan(String value) {
            addCriterion("isMdc >", value, "ismdc");
            return (Criteria) this;
        }

        public Criteria andIsmdcGreaterThanOrEqualTo(String value) {
            addCriterion("isMdc >=", value, "ismdc");
            return (Criteria) this;
        }

        public Criteria andIsmdcLessThan(String value) {
            addCriterion("isMdc <", value, "ismdc");
            return (Criteria) this;
        }

        public Criteria andIsmdcLessThanOrEqualTo(String value) {
            addCriterion("isMdc <=", value, "ismdc");
            return (Criteria) this;
        }

        public Criteria andIsmdcLike(String value) {
            addCriterion("isMdc like", value, "ismdc");
            return (Criteria) this;
        }

        public Criteria andIsmdcNotLike(String value) {
            addCriterion("isMdc not like", value, "ismdc");
            return (Criteria) this;
        }

        public Criteria andIsmdcIn(List<String> values) {
            addCriterion("isMdc in", values, "ismdc");
            return (Criteria) this;
        }

        public Criteria andIsmdcNotIn(List<String> values) {
            addCriterion("isMdc not in", values, "ismdc");
            return (Criteria) this;
        }

        public Criteria andIsmdcBetween(String value1, String value2) {
            addCriterion("isMdc between", value1, value2, "ismdc");
            return (Criteria) this;
        }

        public Criteria andIsmdcNotBetween(String value1, String value2) {
            addCriterion("isMdc not between", value1, value2, "ismdc");
            return (Criteria) this;
        }

        public Criteria andIsexamIsNull() {
            addCriterion("isExam is null");
            return (Criteria) this;
        }

        public Criteria andIsexamIsNotNull() {
            addCriterion("isExam is not null");
            return (Criteria) this;
        }

        public Criteria andIsexamEqualTo(String value) {
            addCriterion("isExam =", value, "isexam");
            return (Criteria) this;
        }

        public Criteria andIsexamNotEqualTo(String value) {
            addCriterion("isExam <>", value, "isexam");
            return (Criteria) this;
        }

        public Criteria andIsexamGreaterThan(String value) {
            addCriterion("isExam >", value, "isexam");
            return (Criteria) this;
        }

        public Criteria andIsexamGreaterThanOrEqualTo(String value) {
            addCriterion("isExam >=", value, "isexam");
            return (Criteria) this;
        }

        public Criteria andIsexamLessThan(String value) {
            addCriterion("isExam <", value, "isexam");
            return (Criteria) this;
        }

        public Criteria andIsexamLessThanOrEqualTo(String value) {
            addCriterion("isExam <=", value, "isexam");
            return (Criteria) this;
        }

        public Criteria andIsexamLike(String value) {
            addCriterion("isExam like", value, "isexam");
            return (Criteria) this;
        }

        public Criteria andIsexamNotLike(String value) {
            addCriterion("isExam not like", value, "isexam");
            return (Criteria) this;
        }

        public Criteria andIsexamIn(List<String> values) {
            addCriterion("isExam in", values, "isexam");
            return (Criteria) this;
        }

        public Criteria andIsexamNotIn(List<String> values) {
            addCriterion("isExam not in", values, "isexam");
            return (Criteria) this;
        }

        public Criteria andIsexamBetween(String value1, String value2) {
            addCriterion("isExam between", value1, value2, "isexam");
            return (Criteria) this;
        }

        public Criteria andIsexamNotBetween(String value1, String value2) {
            addCriterion("isExam not between", value1, value2, "isexam");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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