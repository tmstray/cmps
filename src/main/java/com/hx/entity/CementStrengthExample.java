package com.hx.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CementStrengthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CementStrengthExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIDIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIDIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIDEqualTo(Integer value) {
            addCriterion("ID =", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThan(Integer value) {
            addCriterion("ID >", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThan(Integer value) {
            addCriterion("ID <", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDIn(List<Integer> values) {
            addCriterion("ID in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andSampleIDIsNull() {
            addCriterion("sampleID is null");
            return (Criteria) this;
        }

        public Criteria andSampleIDIsNotNull() {
            addCriterion("sampleID is not null");
            return (Criteria) this;
        }

        public Criteria andSampleIDEqualTo(Integer value) {
            addCriterion("sampleID =", value, "sampleID");
            return (Criteria) this;
        }

        public Criteria andSampleIDNotEqualTo(Integer value) {
            addCriterion("sampleID <>", value, "sampleID");
            return (Criteria) this;
        }

        public Criteria andSampleIDGreaterThan(Integer value) {
            addCriterion("sampleID >", value, "sampleID");
            return (Criteria) this;
        }

        public Criteria andSampleIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("sampleID >=", value, "sampleID");
            return (Criteria) this;
        }

        public Criteria andSampleIDLessThan(Integer value) {
            addCriterion("sampleID <", value, "sampleID");
            return (Criteria) this;
        }

        public Criteria andSampleIDLessThanOrEqualTo(Integer value) {
            addCriterion("sampleID <=", value, "sampleID");
            return (Criteria) this;
        }

        public Criteria andSampleIDIn(List<Integer> values) {
            addCriterion("sampleID in", values, "sampleID");
            return (Criteria) this;
        }

        public Criteria andSampleIDNotIn(List<Integer> values) {
            addCriterion("sampleID not in", values, "sampleID");
            return (Criteria) this;
        }

        public Criteria andSampleIDBetween(Integer value1, Integer value2) {
            addCriterion("sampleID between", value1, value2, "sampleID");
            return (Criteria) this;
        }

        public Criteria andSampleIDNotBetween(Integer value1, Integer value2) {
            addCriterion("sampleID not between", value1, value2, "sampleID");
            return (Criteria) this;
        }

        public Criteria andSampleNoIsNull() {
            addCriterion("sampleNo is null");
            return (Criteria) this;
        }

        public Criteria andSampleNoIsNotNull() {
            addCriterion("sampleNo is not null");
            return (Criteria) this;
        }

        public Criteria andSampleNoEqualTo(String value) {
            addCriterion("sampleNo =", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoNotEqualTo(String value) {
            addCriterion("sampleNo <>", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoGreaterThan(String value) {
            addCriterion("sampleNo >", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoGreaterThanOrEqualTo(String value) {
            addCriterion("sampleNo >=", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoLessThan(String value) {
            addCriterion("sampleNo <", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoLessThanOrEqualTo(String value) {
            addCriterion("sampleNo <=", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoLike(String value) {
            addCriterion("sampleNo like", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoNotLike(String value) {
            addCriterion("sampleNo not like", value, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoIn(List<String> values) {
            addCriterion("sampleNo in", values, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoNotIn(List<String> values) {
            addCriterion("sampleNo not in", values, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoBetween(String value1, String value2) {
            addCriterion("sampleNo between", value1, value2, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andSampleNoNotBetween(String value1, String value2) {
            addCriterion("sampleNo not between", value1, value2, "sampleNo");
            return (Criteria) this;
        }

        public Criteria andKindIsNull() {
            addCriterion("kind is null");
            return (Criteria) this;
        }

        public Criteria andKindIsNotNull() {
            addCriterion("kind is not null");
            return (Criteria) this;
        }

        public Criteria andKindEqualTo(String value) {
            addCriterion("kind =", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotEqualTo(String value) {
            addCriterion("kind <>", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThan(String value) {
            addCriterion("kind >", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThanOrEqualTo(String value) {
            addCriterion("kind >=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThan(String value) {
            addCriterion("kind <", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThanOrEqualTo(String value) {
            addCriterion("kind <=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLike(String value) {
            addCriterion("kind like", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotLike(String value) {
            addCriterion("kind not like", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindIn(List<String> values) {
            addCriterion("kind in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotIn(List<String> values) {
            addCriterion("kind not in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindBetween(String value1, String value2) {
            addCriterion("kind between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotBetween(String value1, String value2) {
            addCriterion("kind not between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andSampleTimeIsNull() {
            addCriterion("sampleTime is null");
            return (Criteria) this;
        }

        public Criteria andSampleTimeIsNotNull() {
            addCriterion("sampleTime is not null");
            return (Criteria) this;
        }

        public Criteria andSampleTimeEqualTo(String value) {
            addCriterion("sampleTime =", value, "sampleTime");
            return (Criteria) this;
        }

        public Criteria andSampleTimeNotEqualTo(String value) {
            addCriterion("sampleTime <>", value, "sampleTime");
            return (Criteria) this;
        }

        public Criteria andSampleTimeGreaterThan(String value) {
            addCriterion("sampleTime >", value, "sampleTime");
            return (Criteria) this;
        }

        public Criteria andSampleTimeGreaterThanOrEqualTo(String value) {
            addCriterion("sampleTime >=", value, "sampleTime");
            return (Criteria) this;
        }

        public Criteria andSampleTimeLessThan(String value) {
            addCriterion("sampleTime <", value, "sampleTime");
            return (Criteria) this;
        }

        public Criteria andSampleTimeLessThanOrEqualTo(String value) {
            addCriterion("sampleTime <=", value, "sampleTime");
            return (Criteria) this;
        }

        public Criteria andSampleTimeLike(String value) {
            addCriterion("sampleTime like", value, "sampleTime");
            return (Criteria) this;
        }

        public Criteria andSampleTimeNotLike(String value) {
            addCriterion("sampleTime not like", value, "sampleTime");
            return (Criteria) this;
        }

        public Criteria andSampleTimeIn(List<String> values) {
            addCriterion("sampleTime in", values, "sampleTime");
            return (Criteria) this;
        }

        public Criteria andSampleTimeNotIn(List<String> values) {
            addCriterion("sampleTime not in", values, "sampleTime");
            return (Criteria) this;
        }

        public Criteria andSampleTimeBetween(String value1, String value2) {
            addCriterion("sampleTime between", value1, value2, "sampleTime");
            return (Criteria) this;
        }

        public Criteria andSampleTimeNotBetween(String value1, String value2) {
            addCriterion("sampleTime not between", value1, value2, "sampleTime");
            return (Criteria) this;
        }

        public Criteria andShapeTimeIsNull() {
            addCriterion("shapeTime is null");
            return (Criteria) this;
        }

        public Criteria andShapeTimeIsNotNull() {
            addCriterion("shapeTime is not null");
            return (Criteria) this;
        }

        public Criteria andShapeTimeEqualTo(String value) {
            addCriterion("shapeTime =", value, "shapeTime");
            return (Criteria) this;
        }

        public Criteria andShapeTimeNotEqualTo(String value) {
            addCriterion("shapeTime <>", value, "shapeTime");
            return (Criteria) this;
        }

        public Criteria andShapeTimeGreaterThan(String value) {
            addCriterion("shapeTime >", value, "shapeTime");
            return (Criteria) this;
        }

        public Criteria andShapeTimeGreaterThanOrEqualTo(String value) {
            addCriterion("shapeTime >=", value, "shapeTime");
            return (Criteria) this;
        }

        public Criteria andShapeTimeLessThan(String value) {
            addCriterion("shapeTime <", value, "shapeTime");
            return (Criteria) this;
        }

        public Criteria andShapeTimeLessThanOrEqualTo(String value) {
            addCriterion("shapeTime <=", value, "shapeTime");
            return (Criteria) this;
        }

        public Criteria andShapeTimeLike(String value) {
            addCriterion("shapeTime like", value, "shapeTime");
            return (Criteria) this;
        }

        public Criteria andShapeTimeNotLike(String value) {
            addCriterion("shapeTime not like", value, "shapeTime");
            return (Criteria) this;
        }

        public Criteria andShapeTimeIn(List<String> values) {
            addCriterion("shapeTime in", values, "shapeTime");
            return (Criteria) this;
        }

        public Criteria andShapeTimeNotIn(List<String> values) {
            addCriterion("shapeTime not in", values, "shapeTime");
            return (Criteria) this;
        }

        public Criteria andShapeTimeBetween(String value1, String value2) {
            addCriterion("shapeTime between", value1, value2, "shapeTime");
            return (Criteria) this;
        }

        public Criteria andShapeTimeNotBetween(String value1, String value2) {
            addCriterion("shapeTime not between", value1, value2, "shapeTime");
            return (Criteria) this;
        }

        public Criteria andDestructTimeIsNull() {
            addCriterion("destructTime is null");
            return (Criteria) this;
        }

        public Criteria andDestructTimeIsNotNull() {
            addCriterion("destructTime is not null");
            return (Criteria) this;
        }

        public Criteria andDestructTimeEqualTo(String value) {
            addCriterion("destructTime =", value, "destructTime");
            return (Criteria) this;
        }

        public Criteria andDestructTimeNotEqualTo(String value) {
            addCriterion("destructTime <>", value, "destructTime");
            return (Criteria) this;
        }

        public Criteria andDestructTimeGreaterThan(String value) {
            addCriterion("destructTime >", value, "destructTime");
            return (Criteria) this;
        }

        public Criteria andDestructTimeGreaterThanOrEqualTo(String value) {
            addCriterion("destructTime >=", value, "destructTime");
            return (Criteria) this;
        }

        public Criteria andDestructTimeLessThan(String value) {
            addCriterion("destructTime <", value, "destructTime");
            return (Criteria) this;
        }

        public Criteria andDestructTimeLessThanOrEqualTo(String value) {
            addCriterion("destructTime <=", value, "destructTime");
            return (Criteria) this;
        }

        public Criteria andDestructTimeLike(String value) {
            addCriterion("destructTime like", value, "destructTime");
            return (Criteria) this;
        }

        public Criteria andDestructTimeNotLike(String value) {
            addCriterion("destructTime not like", value, "destructTime");
            return (Criteria) this;
        }

        public Criteria andDestructTimeIn(List<String> values) {
            addCriterion("destructTime in", values, "destructTime");
            return (Criteria) this;
        }

        public Criteria andDestructTimeNotIn(List<String> values) {
            addCriterion("destructTime not in", values, "destructTime");
            return (Criteria) this;
        }

        public Criteria andDestructTimeBetween(String value1, String value2) {
            addCriterion("destructTime between", value1, value2, "destructTime");
            return (Criteria) this;
        }

        public Criteria andDestructTimeNotBetween(String value1, String value2) {
            addCriterion("destructTime not between", value1, value2, "destructTime");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(String value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(String value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(String value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(String value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(String value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(String value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLike(String value) {
            addCriterion("duration like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotLike(String value) {
            addCriterion("duration not like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<String> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<String> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(String value1, String value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(String value1, String value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andHourIsNull() {
            addCriterion("hour is null");
            return (Criteria) this;
        }

        public Criteria andHourIsNotNull() {
            addCriterion("hour is not null");
            return (Criteria) this;
        }

        public Criteria andHourEqualTo(String value) {
            addCriterion("hour =", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotEqualTo(String value) {
            addCriterion("hour <>", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThan(String value) {
            addCriterion("hour >", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThanOrEqualTo(String value) {
            addCriterion("hour >=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThan(String value) {
            addCriterion("hour <", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThanOrEqualTo(String value) {
            addCriterion("hour <=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLike(String value) {
            addCriterion("hour like", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotLike(String value) {
            addCriterion("hour not like", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourIn(List<String> values) {
            addCriterion("hour in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotIn(List<String> values) {
            addCriterion("hour not in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourBetween(String value1, String value2) {
            addCriterion("hour between", value1, value2, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotBetween(String value1, String value2) {
            addCriterion("hour not between", value1, value2, "hour");
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

        public Criteria andExperimentStandIsNull() {
            addCriterion("experimentStand is null");
            return (Criteria) this;
        }

        public Criteria andExperimentStandIsNotNull() {
            addCriterion("experimentStand is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentStandEqualTo(String value) {
            addCriterion("experimentStand =", value, "experimentStand");
            return (Criteria) this;
        }

        public Criteria andExperimentStandNotEqualTo(String value) {
            addCriterion("experimentStand <>", value, "experimentStand");
            return (Criteria) this;
        }

        public Criteria andExperimentStandGreaterThan(String value) {
            addCriterion("experimentStand >", value, "experimentStand");
            return (Criteria) this;
        }

        public Criteria andExperimentStandGreaterThanOrEqualTo(String value) {
            addCriterion("experimentStand >=", value, "experimentStand");
            return (Criteria) this;
        }

        public Criteria andExperimentStandLessThan(String value) {
            addCriterion("experimentStand <", value, "experimentStand");
            return (Criteria) this;
        }

        public Criteria andExperimentStandLessThanOrEqualTo(String value) {
            addCriterion("experimentStand <=", value, "experimentStand");
            return (Criteria) this;
        }

        public Criteria andExperimentStandLike(String value) {
            addCriterion("experimentStand like", value, "experimentStand");
            return (Criteria) this;
        }

        public Criteria andExperimentStandNotLike(String value) {
            addCriterion("experimentStand not like", value, "experimentStand");
            return (Criteria) this;
        }

        public Criteria andExperimentStandIn(List<String> values) {
            addCriterion("experimentStand in", values, "experimentStand");
            return (Criteria) this;
        }

        public Criteria andExperimentStandNotIn(List<String> values) {
            addCriterion("experimentStand not in", values, "experimentStand");
            return (Criteria) this;
        }

        public Criteria andExperimentStandBetween(String value1, String value2) {
            addCriterion("experimentStand between", value1, value2, "experimentStand");
            return (Criteria) this;
        }

        public Criteria andExperimentStandNotBetween(String value1, String value2) {
            addCriterion("experimentStand not between", value1, value2, "experimentStand");
            return (Criteria) this;
        }

        public Criteria andStressTypeIsNull() {
            addCriterion("stressType is null");
            return (Criteria) this;
        }

        public Criteria andStressTypeIsNotNull() {
            addCriterion("stressType is not null");
            return (Criteria) this;
        }

        public Criteria andStressTypeEqualTo(String value) {
            addCriterion("stressType =", value, "stressType");
            return (Criteria) this;
        }

        public Criteria andStressTypeNotEqualTo(String value) {
            addCriterion("stressType <>", value, "stressType");
            return (Criteria) this;
        }

        public Criteria andStressTypeGreaterThan(String value) {
            addCriterion("stressType >", value, "stressType");
            return (Criteria) this;
        }

        public Criteria andStressTypeGreaterThanOrEqualTo(String value) {
            addCriterion("stressType >=", value, "stressType");
            return (Criteria) this;
        }

        public Criteria andStressTypeLessThan(String value) {
            addCriterion("stressType <", value, "stressType");
            return (Criteria) this;
        }

        public Criteria andStressTypeLessThanOrEqualTo(String value) {
            addCriterion("stressType <=", value, "stressType");
            return (Criteria) this;
        }

        public Criteria andStressTypeLike(String value) {
            addCriterion("stressType like", value, "stressType");
            return (Criteria) this;
        }

        public Criteria andStressTypeNotLike(String value) {
            addCriterion("stressType not like", value, "stressType");
            return (Criteria) this;
        }

        public Criteria andStressTypeIn(List<String> values) {
            addCriterion("stressType in", values, "stressType");
            return (Criteria) this;
        }

        public Criteria andStressTypeNotIn(List<String> values) {
            addCriterion("stressType not in", values, "stressType");
            return (Criteria) this;
        }

        public Criteria andStressTypeBetween(String value1, String value2) {
            addCriterion("stressType between", value1, value2, "stressType");
            return (Criteria) this;
        }

        public Criteria andStressTypeNotBetween(String value1, String value2) {
            addCriterion("stressType not between", value1, value2, "stressType");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeIsNull() {
            addCriterion("flexureType is null");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeIsNotNull() {
            addCriterion("flexureType is not null");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeEqualTo(String value) {
            addCriterion("flexureType =", value, "flexureType");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeNotEqualTo(String value) {
            addCriterion("flexureType <>", value, "flexureType");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeGreaterThan(String value) {
            addCriterion("flexureType >", value, "flexureType");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeGreaterThanOrEqualTo(String value) {
            addCriterion("flexureType >=", value, "flexureType");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeLessThan(String value) {
            addCriterion("flexureType <", value, "flexureType");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeLessThanOrEqualTo(String value) {
            addCriterion("flexureType <=", value, "flexureType");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeLike(String value) {
            addCriterion("flexureType like", value, "flexureType");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeNotLike(String value) {
            addCriterion("flexureType not like", value, "flexureType");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeIn(List<String> values) {
            addCriterion("flexureType in", values, "flexureType");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeNotIn(List<String> values) {
            addCriterion("flexureType not in", values, "flexureType");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeBetween(String value1, String value2) {
            addCriterion("flexureType between", value1, value2, "flexureType");
            return (Criteria) this;
        }

        public Criteria andFlexureTypeNotBetween(String value1, String value2) {
            addCriterion("flexureType not between", value1, value2, "flexureType");
            return (Criteria) this;
        }

        public Criteria andStressNoIsNull() {
            addCriterion("stressNo is null");
            return (Criteria) this;
        }

        public Criteria andStressNoIsNotNull() {
            addCriterion("stressNo is not null");
            return (Criteria) this;
        }

        public Criteria andStressNoEqualTo(String value) {
            addCriterion("stressNo =", value, "stressNo");
            return (Criteria) this;
        }

        public Criteria andStressNoNotEqualTo(String value) {
            addCriterion("stressNo <>", value, "stressNo");
            return (Criteria) this;
        }

        public Criteria andStressNoGreaterThan(String value) {
            addCriterion("stressNo >", value, "stressNo");
            return (Criteria) this;
        }

        public Criteria andStressNoGreaterThanOrEqualTo(String value) {
            addCriterion("stressNo >=", value, "stressNo");
            return (Criteria) this;
        }

        public Criteria andStressNoLessThan(String value) {
            addCriterion("stressNo <", value, "stressNo");
            return (Criteria) this;
        }

        public Criteria andStressNoLessThanOrEqualTo(String value) {
            addCriterion("stressNo <=", value, "stressNo");
            return (Criteria) this;
        }

        public Criteria andStressNoLike(String value) {
            addCriterion("stressNo like", value, "stressNo");
            return (Criteria) this;
        }

        public Criteria andStressNoNotLike(String value) {
            addCriterion("stressNo not like", value, "stressNo");
            return (Criteria) this;
        }

        public Criteria andStressNoIn(List<String> values) {
            addCriterion("stressNo in", values, "stressNo");
            return (Criteria) this;
        }

        public Criteria andStressNoNotIn(List<String> values) {
            addCriterion("stressNo not in", values, "stressNo");
            return (Criteria) this;
        }

        public Criteria andStressNoBetween(String value1, String value2) {
            addCriterion("stressNo between", value1, value2, "stressNo");
            return (Criteria) this;
        }

        public Criteria andStressNoNotBetween(String value1, String value2) {
            addCriterion("stressNo not between", value1, value2, "stressNo");
            return (Criteria) this;
        }

        public Criteria andFlexureNoIsNull() {
            addCriterion("flexureNo is null");
            return (Criteria) this;
        }

        public Criteria andFlexureNoIsNotNull() {
            addCriterion("flexureNo is not null");
            return (Criteria) this;
        }

        public Criteria andFlexureNoEqualTo(String value) {
            addCriterion("flexureNo =", value, "flexureNo");
            return (Criteria) this;
        }

        public Criteria andFlexureNoNotEqualTo(String value) {
            addCriterion("flexureNo <>", value, "flexureNo");
            return (Criteria) this;
        }

        public Criteria andFlexureNoGreaterThan(String value) {
            addCriterion("flexureNo >", value, "flexureNo");
            return (Criteria) this;
        }

        public Criteria andFlexureNoGreaterThanOrEqualTo(String value) {
            addCriterion("flexureNo >=", value, "flexureNo");
            return (Criteria) this;
        }

        public Criteria andFlexureNoLessThan(String value) {
            addCriterion("flexureNo <", value, "flexureNo");
            return (Criteria) this;
        }

        public Criteria andFlexureNoLessThanOrEqualTo(String value) {
            addCriterion("flexureNo <=", value, "flexureNo");
            return (Criteria) this;
        }

        public Criteria andFlexureNoLike(String value) {
            addCriterion("flexureNo like", value, "flexureNo");
            return (Criteria) this;
        }

        public Criteria andFlexureNoNotLike(String value) {
            addCriterion("flexureNo not like", value, "flexureNo");
            return (Criteria) this;
        }

        public Criteria andFlexureNoIn(List<String> values) {
            addCriterion("flexureNo in", values, "flexureNo");
            return (Criteria) this;
        }

        public Criteria andFlexureNoNotIn(List<String> values) {
            addCriterion("flexureNo not in", values, "flexureNo");
            return (Criteria) this;
        }

        public Criteria andFlexureNoBetween(String value1, String value2) {
            addCriterion("flexureNo between", value1, value2, "flexureNo");
            return (Criteria) this;
        }

        public Criteria andFlexureNoNotBetween(String value1, String value2) {
            addCriterion("flexureNo not between", value1, value2, "flexureNo");
            return (Criteria) this;
        }

        public Criteria andStressStaIsNull() {
            addCriterion("stressSta is null");
            return (Criteria) this;
        }

        public Criteria andStressStaIsNotNull() {
            addCriterion("stressSta is not null");
            return (Criteria) this;
        }

        public Criteria andStressStaEqualTo(String value) {
            addCriterion("stressSta =", value, "stressSta");
            return (Criteria) this;
        }

        public Criteria andStressStaNotEqualTo(String value) {
            addCriterion("stressSta <>", value, "stressSta");
            return (Criteria) this;
        }

        public Criteria andStressStaGreaterThan(String value) {
            addCriterion("stressSta >", value, "stressSta");
            return (Criteria) this;
        }

        public Criteria andStressStaGreaterThanOrEqualTo(String value) {
            addCriterion("stressSta >=", value, "stressSta");
            return (Criteria) this;
        }

        public Criteria andStressStaLessThan(String value) {
            addCriterion("stressSta <", value, "stressSta");
            return (Criteria) this;
        }

        public Criteria andStressStaLessThanOrEqualTo(String value) {
            addCriterion("stressSta <=", value, "stressSta");
            return (Criteria) this;
        }

        public Criteria andStressStaLike(String value) {
            addCriterion("stressSta like", value, "stressSta");
            return (Criteria) this;
        }

        public Criteria andStressStaNotLike(String value) {
            addCriterion("stressSta not like", value, "stressSta");
            return (Criteria) this;
        }

        public Criteria andStressStaIn(List<String> values) {
            addCriterion("stressSta in", values, "stressSta");
            return (Criteria) this;
        }

        public Criteria andStressStaNotIn(List<String> values) {
            addCriterion("stressSta not in", values, "stressSta");
            return (Criteria) this;
        }

        public Criteria andStressStaBetween(String value1, String value2) {
            addCriterion("stressSta between", value1, value2, "stressSta");
            return (Criteria) this;
        }

        public Criteria andStressStaNotBetween(String value1, String value2) {
            addCriterion("stressSta not between", value1, value2, "stressSta");
            return (Criteria) this;
        }

        public Criteria andFlexureStaIsNull() {
            addCriterion("flexureSta is null");
            return (Criteria) this;
        }

        public Criteria andFlexureStaIsNotNull() {
            addCriterion("flexureSta is not null");
            return (Criteria) this;
        }

        public Criteria andFlexureStaEqualTo(String value) {
            addCriterion("flexureSta =", value, "flexureSta");
            return (Criteria) this;
        }

        public Criteria andFlexureStaNotEqualTo(String value) {
            addCriterion("flexureSta <>", value, "flexureSta");
            return (Criteria) this;
        }

        public Criteria andFlexureStaGreaterThan(String value) {
            addCriterion("flexureSta >", value, "flexureSta");
            return (Criteria) this;
        }

        public Criteria andFlexureStaGreaterThanOrEqualTo(String value) {
            addCriterion("flexureSta >=", value, "flexureSta");
            return (Criteria) this;
        }

        public Criteria andFlexureStaLessThan(String value) {
            addCriterion("flexureSta <", value, "flexureSta");
            return (Criteria) this;
        }

        public Criteria andFlexureStaLessThanOrEqualTo(String value) {
            addCriterion("flexureSta <=", value, "flexureSta");
            return (Criteria) this;
        }

        public Criteria andFlexureStaLike(String value) {
            addCriterion("flexureSta like", value, "flexureSta");
            return (Criteria) this;
        }

        public Criteria andFlexureStaNotLike(String value) {
            addCriterion("flexureSta not like", value, "flexureSta");
            return (Criteria) this;
        }

        public Criteria andFlexureStaIn(List<String> values) {
            addCriterion("flexureSta in", values, "flexureSta");
            return (Criteria) this;
        }

        public Criteria andFlexureStaNotIn(List<String> values) {
            addCriterion("flexureSta not in", values, "flexureSta");
            return (Criteria) this;
        }

        public Criteria andFlexureStaBetween(String value1, String value2) {
            addCriterion("flexureSta between", value1, value2, "flexureSta");
            return (Criteria) this;
        }

        public Criteria andFlexureStaNotBetween(String value1, String value2) {
            addCriterion("flexureSta not between", value1, value2, "flexureSta");
            return (Criteria) this;
        }

        public Criteria andStressVailIsNull() {
            addCriterion("stressVail is null");
            return (Criteria) this;
        }

        public Criteria andStressVailIsNotNull() {
            addCriterion("stressVail is not null");
            return (Criteria) this;
        }

        public Criteria andStressVailEqualTo(String value) {
            addCriterion("stressVail =", value, "stressVail");
            return (Criteria) this;
        }

        public Criteria andStressVailNotEqualTo(String value) {
            addCriterion("stressVail <>", value, "stressVail");
            return (Criteria) this;
        }

        public Criteria andStressVailGreaterThan(String value) {
            addCriterion("stressVail >", value, "stressVail");
            return (Criteria) this;
        }

        public Criteria andStressVailGreaterThanOrEqualTo(String value) {
            addCriterion("stressVail >=", value, "stressVail");
            return (Criteria) this;
        }

        public Criteria andStressVailLessThan(String value) {
            addCriterion("stressVail <", value, "stressVail");
            return (Criteria) this;
        }

        public Criteria andStressVailLessThanOrEqualTo(String value) {
            addCriterion("stressVail <=", value, "stressVail");
            return (Criteria) this;
        }

        public Criteria andStressVailLike(String value) {
            addCriterion("stressVail like", value, "stressVail");
            return (Criteria) this;
        }

        public Criteria andStressVailNotLike(String value) {
            addCriterion("stressVail not like", value, "stressVail");
            return (Criteria) this;
        }

        public Criteria andStressVailIn(List<String> values) {
            addCriterion("stressVail in", values, "stressVail");
            return (Criteria) this;
        }

        public Criteria andStressVailNotIn(List<String> values) {
            addCriterion("stressVail not in", values, "stressVail");
            return (Criteria) this;
        }

        public Criteria andStressVailBetween(String value1, String value2) {
            addCriterion("stressVail between", value1, value2, "stressVail");
            return (Criteria) this;
        }

        public Criteria andStressVailNotBetween(String value1, String value2) {
            addCriterion("stressVail not between", value1, value2, "stressVail");
            return (Criteria) this;
        }

        public Criteria andFlexureVailIsNull() {
            addCriterion("flexureVail is null");
            return (Criteria) this;
        }

        public Criteria andFlexureVailIsNotNull() {
            addCriterion("flexureVail is not null");
            return (Criteria) this;
        }

        public Criteria andFlexureVailEqualTo(String value) {
            addCriterion("flexureVail =", value, "flexureVail");
            return (Criteria) this;
        }

        public Criteria andFlexureVailNotEqualTo(String value) {
            addCriterion("flexureVail <>", value, "flexureVail");
            return (Criteria) this;
        }

        public Criteria andFlexureVailGreaterThan(String value) {
            addCriterion("flexureVail >", value, "flexureVail");
            return (Criteria) this;
        }

        public Criteria andFlexureVailGreaterThanOrEqualTo(String value) {
            addCriterion("flexureVail >=", value, "flexureVail");
            return (Criteria) this;
        }

        public Criteria andFlexureVailLessThan(String value) {
            addCriterion("flexureVail <", value, "flexureVail");
            return (Criteria) this;
        }

        public Criteria andFlexureVailLessThanOrEqualTo(String value) {
            addCriterion("flexureVail <=", value, "flexureVail");
            return (Criteria) this;
        }

        public Criteria andFlexureVailLike(String value) {
            addCriterion("flexureVail like", value, "flexureVail");
            return (Criteria) this;
        }

        public Criteria andFlexureVailNotLike(String value) {
            addCriterion("flexureVail not like", value, "flexureVail");
            return (Criteria) this;
        }

        public Criteria andFlexureVailIn(List<String> values) {
            addCriterion("flexureVail in", values, "flexureVail");
            return (Criteria) this;
        }

        public Criteria andFlexureVailNotIn(List<String> values) {
            addCriterion("flexureVail not in", values, "flexureVail");
            return (Criteria) this;
        }

        public Criteria andFlexureVailBetween(String value1, String value2) {
            addCriterion("flexureVail between", value1, value2, "flexureVail");
            return (Criteria) this;
        }

        public Criteria andFlexureVailNotBetween(String value1, String value2) {
            addCriterion("flexureVail not between", value1, value2, "flexureVail");
            return (Criteria) this;
        }

        public Criteria andStressCKSIsNull() {
            addCriterion("stressCKS is null");
            return (Criteria) this;
        }

        public Criteria andStressCKSIsNotNull() {
            addCriterion("stressCKS is not null");
            return (Criteria) this;
        }

        public Criteria andStressCKSEqualTo(String value) {
            addCriterion("stressCKS =", value, "stressCKS");
            return (Criteria) this;
        }

        public Criteria andStressCKSNotEqualTo(String value) {
            addCriterion("stressCKS <>", value, "stressCKS");
            return (Criteria) this;
        }

        public Criteria andStressCKSGreaterThan(String value) {
            addCriterion("stressCKS >", value, "stressCKS");
            return (Criteria) this;
        }

        public Criteria andStressCKSGreaterThanOrEqualTo(String value) {
            addCriterion("stressCKS >=", value, "stressCKS");
            return (Criteria) this;
        }

        public Criteria andStressCKSLessThan(String value) {
            addCriterion("stressCKS <", value, "stressCKS");
            return (Criteria) this;
        }

        public Criteria andStressCKSLessThanOrEqualTo(String value) {
            addCriterion("stressCKS <=", value, "stressCKS");
            return (Criteria) this;
        }

        public Criteria andStressCKSLike(String value) {
            addCriterion("stressCKS like", value, "stressCKS");
            return (Criteria) this;
        }

        public Criteria andStressCKSNotLike(String value) {
            addCriterion("stressCKS not like", value, "stressCKS");
            return (Criteria) this;
        }

        public Criteria andStressCKSIn(List<String> values) {
            addCriterion("stressCKS in", values, "stressCKS");
            return (Criteria) this;
        }

        public Criteria andStressCKSNotIn(List<String> values) {
            addCriterion("stressCKS not in", values, "stressCKS");
            return (Criteria) this;
        }

        public Criteria andStressCKSBetween(String value1, String value2) {
            addCriterion("stressCKS between", value1, value2, "stressCKS");
            return (Criteria) this;
        }

        public Criteria andStressCKSNotBetween(String value1, String value2) {
            addCriterion("stressCKS not between", value1, value2, "stressCKS");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSIsNull() {
            addCriterion("flexureCKS is null");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSIsNotNull() {
            addCriterion("flexureCKS is not null");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSEqualTo(String value) {
            addCriterion("flexureCKS =", value, "flexureCKS");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSNotEqualTo(String value) {
            addCriterion("flexureCKS <>", value, "flexureCKS");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSGreaterThan(String value) {
            addCriterion("flexureCKS >", value, "flexureCKS");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSGreaterThanOrEqualTo(String value) {
            addCriterion("flexureCKS >=", value, "flexureCKS");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSLessThan(String value) {
            addCriterion("flexureCKS <", value, "flexureCKS");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSLessThanOrEqualTo(String value) {
            addCriterion("flexureCKS <=", value, "flexureCKS");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSLike(String value) {
            addCriterion("flexureCKS like", value, "flexureCKS");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSNotLike(String value) {
            addCriterion("flexureCKS not like", value, "flexureCKS");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSIn(List<String> values) {
            addCriterion("flexureCKS in", values, "flexureCKS");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSNotIn(List<String> values) {
            addCriterion("flexureCKS not in", values, "flexureCKS");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSBetween(String value1, String value2) {
            addCriterion("flexureCKS between", value1, value2, "flexureCKS");
            return (Criteria) this;
        }

        public Criteria andFlexureCKSNotBetween(String value1, String value2) {
            addCriterion("flexureCKS not between", value1, value2, "flexureCKS");
            return (Criteria) this;
        }

        public Criteria andNotesIsNull() {
            addCriterion("notes is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("notes is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(String value) {
            addCriterion("notes =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(String value) {
            addCriterion("notes <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(String value) {
            addCriterion("notes >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(String value) {
            addCriterion("notes >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(String value) {
            addCriterion("notes <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(String value) {
            addCriterion("notes <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLike(String value) {
            addCriterion("notes like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotLike(String value) {
            addCriterion("notes not like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<String> values) {
            addCriterion("notes in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<String> values) {
            addCriterion("notes not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(String value1, String value2) {
            addCriterion("notes between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(String value1, String value2) {
            addCriterion("notes not between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andStress1IsNull() {
            addCriterion("stress1 is null");
            return (Criteria) this;
        }

        public Criteria andStress1IsNotNull() {
            addCriterion("stress1 is not null");
            return (Criteria) this;
        }

        public Criteria andStress1EqualTo(String value) {
            addCriterion("stress1 =", value, "stress1");
            return (Criteria) this;
        }

        public Criteria andStress1NotEqualTo(String value) {
            addCriterion("stress1 <>", value, "stress1");
            return (Criteria) this;
        }

        public Criteria andStress1GreaterThan(String value) {
            addCriterion("stress1 >", value, "stress1");
            return (Criteria) this;
        }

        public Criteria andStress1GreaterThanOrEqualTo(String value) {
            addCriterion("stress1 >=", value, "stress1");
            return (Criteria) this;
        }

        public Criteria andStress1LessThan(String value) {
            addCriterion("stress1 <", value, "stress1");
            return (Criteria) this;
        }

        public Criteria andStress1LessThanOrEqualTo(String value) {
            addCriterion("stress1 <=", value, "stress1");
            return (Criteria) this;
        }

        public Criteria andStress1Like(String value) {
            addCriterion("stress1 like", value, "stress1");
            return (Criteria) this;
        }

        public Criteria andStress1NotLike(String value) {
            addCriterion("stress1 not like", value, "stress1");
            return (Criteria) this;
        }

        public Criteria andStress1In(List<String> values) {
            addCriterion("stress1 in", values, "stress1");
            return (Criteria) this;
        }

        public Criteria andStress1NotIn(List<String> values) {
            addCriterion("stress1 not in", values, "stress1");
            return (Criteria) this;
        }

        public Criteria andStress1Between(String value1, String value2) {
            addCriterion("stress1 between", value1, value2, "stress1");
            return (Criteria) this;
        }

        public Criteria andStress1NotBetween(String value1, String value2) {
            addCriterion("stress1 not between", value1, value2, "stress1");
            return (Criteria) this;
        }

        public Criteria andStress2IsNull() {
            addCriterion("stress2 is null");
            return (Criteria) this;
        }

        public Criteria andStress2IsNotNull() {
            addCriterion("stress2 is not null");
            return (Criteria) this;
        }

        public Criteria andStress2EqualTo(String value) {
            addCriterion("stress2 =", value, "stress2");
            return (Criteria) this;
        }

        public Criteria andStress2NotEqualTo(String value) {
            addCriterion("stress2 <>", value, "stress2");
            return (Criteria) this;
        }

        public Criteria andStress2GreaterThan(String value) {
            addCriterion("stress2 >", value, "stress2");
            return (Criteria) this;
        }

        public Criteria andStress2GreaterThanOrEqualTo(String value) {
            addCriterion("stress2 >=", value, "stress2");
            return (Criteria) this;
        }

        public Criteria andStress2LessThan(String value) {
            addCriterion("stress2 <", value, "stress2");
            return (Criteria) this;
        }

        public Criteria andStress2LessThanOrEqualTo(String value) {
            addCriterion("stress2 <=", value, "stress2");
            return (Criteria) this;
        }

        public Criteria andStress2Like(String value) {
            addCriterion("stress2 like", value, "stress2");
            return (Criteria) this;
        }

        public Criteria andStress2NotLike(String value) {
            addCriterion("stress2 not like", value, "stress2");
            return (Criteria) this;
        }

        public Criteria andStress2In(List<String> values) {
            addCriterion("stress2 in", values, "stress2");
            return (Criteria) this;
        }

        public Criteria andStress2NotIn(List<String> values) {
            addCriterion("stress2 not in", values, "stress2");
            return (Criteria) this;
        }

        public Criteria andStress2Between(String value1, String value2) {
            addCriterion("stress2 between", value1, value2, "stress2");
            return (Criteria) this;
        }

        public Criteria andStress2NotBetween(String value1, String value2) {
            addCriterion("stress2 not between", value1, value2, "stress2");
            return (Criteria) this;
        }

        public Criteria andStress3IsNull() {
            addCriterion("stress3 is null");
            return (Criteria) this;
        }

        public Criteria andStress3IsNotNull() {
            addCriterion("stress3 is not null");
            return (Criteria) this;
        }

        public Criteria andStress3EqualTo(String value) {
            addCriterion("stress3 =", value, "stress3");
            return (Criteria) this;
        }

        public Criteria andStress3NotEqualTo(String value) {
            addCriterion("stress3 <>", value, "stress3");
            return (Criteria) this;
        }

        public Criteria andStress3GreaterThan(String value) {
            addCriterion("stress3 >", value, "stress3");
            return (Criteria) this;
        }

        public Criteria andStress3GreaterThanOrEqualTo(String value) {
            addCriterion("stress3 >=", value, "stress3");
            return (Criteria) this;
        }

        public Criteria andStress3LessThan(String value) {
            addCriterion("stress3 <", value, "stress3");
            return (Criteria) this;
        }

        public Criteria andStress3LessThanOrEqualTo(String value) {
            addCriterion("stress3 <=", value, "stress3");
            return (Criteria) this;
        }

        public Criteria andStress3Like(String value) {
            addCriterion("stress3 like", value, "stress3");
            return (Criteria) this;
        }

        public Criteria andStress3NotLike(String value) {
            addCriterion("stress3 not like", value, "stress3");
            return (Criteria) this;
        }

        public Criteria andStress3In(List<String> values) {
            addCriterion("stress3 in", values, "stress3");
            return (Criteria) this;
        }

        public Criteria andStress3NotIn(List<String> values) {
            addCriterion("stress3 not in", values, "stress3");
            return (Criteria) this;
        }

        public Criteria andStress3Between(String value1, String value2) {
            addCriterion("stress3 between", value1, value2, "stress3");
            return (Criteria) this;
        }

        public Criteria andStress3NotBetween(String value1, String value2) {
            addCriterion("stress3 not between", value1, value2, "stress3");
            return (Criteria) this;
        }

        public Criteria andStress4IsNull() {
            addCriterion("stress4 is null");
            return (Criteria) this;
        }

        public Criteria andStress4IsNotNull() {
            addCriterion("stress4 is not null");
            return (Criteria) this;
        }

        public Criteria andStress4EqualTo(String value) {
            addCriterion("stress4 =", value, "stress4");
            return (Criteria) this;
        }

        public Criteria andStress4NotEqualTo(String value) {
            addCriterion("stress4 <>", value, "stress4");
            return (Criteria) this;
        }

        public Criteria andStress4GreaterThan(String value) {
            addCriterion("stress4 >", value, "stress4");
            return (Criteria) this;
        }

        public Criteria andStress4GreaterThanOrEqualTo(String value) {
            addCriterion("stress4 >=", value, "stress4");
            return (Criteria) this;
        }

        public Criteria andStress4LessThan(String value) {
            addCriterion("stress4 <", value, "stress4");
            return (Criteria) this;
        }

        public Criteria andStress4LessThanOrEqualTo(String value) {
            addCriterion("stress4 <=", value, "stress4");
            return (Criteria) this;
        }

        public Criteria andStress4Like(String value) {
            addCriterion("stress4 like", value, "stress4");
            return (Criteria) this;
        }

        public Criteria andStress4NotLike(String value) {
            addCriterion("stress4 not like", value, "stress4");
            return (Criteria) this;
        }

        public Criteria andStress4In(List<String> values) {
            addCriterion("stress4 in", values, "stress4");
            return (Criteria) this;
        }

        public Criteria andStress4NotIn(List<String> values) {
            addCriterion("stress4 not in", values, "stress4");
            return (Criteria) this;
        }

        public Criteria andStress4Between(String value1, String value2) {
            addCriterion("stress4 between", value1, value2, "stress4");
            return (Criteria) this;
        }

        public Criteria andStress4NotBetween(String value1, String value2) {
            addCriterion("stress4 not between", value1, value2, "stress4");
            return (Criteria) this;
        }

        public Criteria andStress5IsNull() {
            addCriterion("stress5 is null");
            return (Criteria) this;
        }

        public Criteria andStress5IsNotNull() {
            addCriterion("stress5 is not null");
            return (Criteria) this;
        }

        public Criteria andStress5EqualTo(String value) {
            addCriterion("stress5 =", value, "stress5");
            return (Criteria) this;
        }

        public Criteria andStress5NotEqualTo(String value) {
            addCriterion("stress5 <>", value, "stress5");
            return (Criteria) this;
        }

        public Criteria andStress5GreaterThan(String value) {
            addCriterion("stress5 >", value, "stress5");
            return (Criteria) this;
        }

        public Criteria andStress5GreaterThanOrEqualTo(String value) {
            addCriterion("stress5 >=", value, "stress5");
            return (Criteria) this;
        }

        public Criteria andStress5LessThan(String value) {
            addCriterion("stress5 <", value, "stress5");
            return (Criteria) this;
        }

        public Criteria andStress5LessThanOrEqualTo(String value) {
            addCriterion("stress5 <=", value, "stress5");
            return (Criteria) this;
        }

        public Criteria andStress5Like(String value) {
            addCriterion("stress5 like", value, "stress5");
            return (Criteria) this;
        }

        public Criteria andStress5NotLike(String value) {
            addCriterion("stress5 not like", value, "stress5");
            return (Criteria) this;
        }

        public Criteria andStress5In(List<String> values) {
            addCriterion("stress5 in", values, "stress5");
            return (Criteria) this;
        }

        public Criteria andStress5NotIn(List<String> values) {
            addCriterion("stress5 not in", values, "stress5");
            return (Criteria) this;
        }

        public Criteria andStress5Between(String value1, String value2) {
            addCriterion("stress5 between", value1, value2, "stress5");
            return (Criteria) this;
        }

        public Criteria andStress5NotBetween(String value1, String value2) {
            addCriterion("stress5 not between", value1, value2, "stress5");
            return (Criteria) this;
        }

        public Criteria andStress6IsNull() {
            addCriterion("stress6 is null");
            return (Criteria) this;
        }

        public Criteria andStress6IsNotNull() {
            addCriterion("stress6 is not null");
            return (Criteria) this;
        }

        public Criteria andStress6EqualTo(String value) {
            addCriterion("stress6 =", value, "stress6");
            return (Criteria) this;
        }

        public Criteria andStress6NotEqualTo(String value) {
            addCriterion("stress6 <>", value, "stress6");
            return (Criteria) this;
        }

        public Criteria andStress6GreaterThan(String value) {
            addCriterion("stress6 >", value, "stress6");
            return (Criteria) this;
        }

        public Criteria andStress6GreaterThanOrEqualTo(String value) {
            addCriterion("stress6 >=", value, "stress6");
            return (Criteria) this;
        }

        public Criteria andStress6LessThan(String value) {
            addCriterion("stress6 <", value, "stress6");
            return (Criteria) this;
        }

        public Criteria andStress6LessThanOrEqualTo(String value) {
            addCriterion("stress6 <=", value, "stress6");
            return (Criteria) this;
        }

        public Criteria andStress6Like(String value) {
            addCriterion("stress6 like", value, "stress6");
            return (Criteria) this;
        }

        public Criteria andStress6NotLike(String value) {
            addCriterion("stress6 not like", value, "stress6");
            return (Criteria) this;
        }

        public Criteria andStress6In(List<String> values) {
            addCriterion("stress6 in", values, "stress6");
            return (Criteria) this;
        }

        public Criteria andStress6NotIn(List<String> values) {
            addCriterion("stress6 not in", values, "stress6");
            return (Criteria) this;
        }

        public Criteria andStress6Between(String value1, String value2) {
            addCriterion("stress6 between", value1, value2, "stress6");
            return (Criteria) this;
        }

        public Criteria andStress6NotBetween(String value1, String value2) {
            addCriterion("stress6 not between", value1, value2, "stress6");
            return (Criteria) this;
        }

        public Criteria andPressure1IsNull() {
            addCriterion("pressure1 is null");
            return (Criteria) this;
        }

        public Criteria andPressure1IsNotNull() {
            addCriterion("pressure1 is not null");
            return (Criteria) this;
        }

        public Criteria andPressure1EqualTo(String value) {
            addCriterion("pressure1 =", value, "pressure1");
            return (Criteria) this;
        }

        public Criteria andPressure1NotEqualTo(String value) {
            addCriterion("pressure1 <>", value, "pressure1");
            return (Criteria) this;
        }

        public Criteria andPressure1GreaterThan(String value) {
            addCriterion("pressure1 >", value, "pressure1");
            return (Criteria) this;
        }

        public Criteria andPressure1GreaterThanOrEqualTo(String value) {
            addCriterion("pressure1 >=", value, "pressure1");
            return (Criteria) this;
        }

        public Criteria andPressure1LessThan(String value) {
            addCriterion("pressure1 <", value, "pressure1");
            return (Criteria) this;
        }

        public Criteria andPressure1LessThanOrEqualTo(String value) {
            addCriterion("pressure1 <=", value, "pressure1");
            return (Criteria) this;
        }

        public Criteria andPressure1Like(String value) {
            addCriterion("pressure1 like", value, "pressure1");
            return (Criteria) this;
        }

        public Criteria andPressure1NotLike(String value) {
            addCriterion("pressure1 not like", value, "pressure1");
            return (Criteria) this;
        }

        public Criteria andPressure1In(List<String> values) {
            addCriterion("pressure1 in", values, "pressure1");
            return (Criteria) this;
        }

        public Criteria andPressure1NotIn(List<String> values) {
            addCriterion("pressure1 not in", values, "pressure1");
            return (Criteria) this;
        }

        public Criteria andPressure1Between(String value1, String value2) {
            addCriterion("pressure1 between", value1, value2, "pressure1");
            return (Criteria) this;
        }

        public Criteria andPressure1NotBetween(String value1, String value2) {
            addCriterion("pressure1 not between", value1, value2, "pressure1");
            return (Criteria) this;
        }

        public Criteria andPressure2IsNull() {
            addCriterion("pressure2 is null");
            return (Criteria) this;
        }

        public Criteria andPressure2IsNotNull() {
            addCriterion("pressure2 is not null");
            return (Criteria) this;
        }

        public Criteria andPressure2EqualTo(String value) {
            addCriterion("pressure2 =", value, "pressure2");
            return (Criteria) this;
        }

        public Criteria andPressure2NotEqualTo(String value) {
            addCriterion("pressure2 <>", value, "pressure2");
            return (Criteria) this;
        }

        public Criteria andPressure2GreaterThan(String value) {
            addCriterion("pressure2 >", value, "pressure2");
            return (Criteria) this;
        }

        public Criteria andPressure2GreaterThanOrEqualTo(String value) {
            addCriterion("pressure2 >=", value, "pressure2");
            return (Criteria) this;
        }

        public Criteria andPressure2LessThan(String value) {
            addCriterion("pressure2 <", value, "pressure2");
            return (Criteria) this;
        }

        public Criteria andPressure2LessThanOrEqualTo(String value) {
            addCriterion("pressure2 <=", value, "pressure2");
            return (Criteria) this;
        }

        public Criteria andPressure2Like(String value) {
            addCriterion("pressure2 like", value, "pressure2");
            return (Criteria) this;
        }

        public Criteria andPressure2NotLike(String value) {
            addCriterion("pressure2 not like", value, "pressure2");
            return (Criteria) this;
        }

        public Criteria andPressure2In(List<String> values) {
            addCriterion("pressure2 in", values, "pressure2");
            return (Criteria) this;
        }

        public Criteria andPressure2NotIn(List<String> values) {
            addCriterion("pressure2 not in", values, "pressure2");
            return (Criteria) this;
        }

        public Criteria andPressure2Between(String value1, String value2) {
            addCriterion("pressure2 between", value1, value2, "pressure2");
            return (Criteria) this;
        }

        public Criteria andPressure2NotBetween(String value1, String value2) {
            addCriterion("pressure2 not between", value1, value2, "pressure2");
            return (Criteria) this;
        }

        public Criteria andPressure3IsNull() {
            addCriterion("pressure3 is null");
            return (Criteria) this;
        }

        public Criteria andPressure3IsNotNull() {
            addCriterion("pressure3 is not null");
            return (Criteria) this;
        }

        public Criteria andPressure3EqualTo(String value) {
            addCriterion("pressure3 =", value, "pressure3");
            return (Criteria) this;
        }

        public Criteria andPressure3NotEqualTo(String value) {
            addCriterion("pressure3 <>", value, "pressure3");
            return (Criteria) this;
        }

        public Criteria andPressure3GreaterThan(String value) {
            addCriterion("pressure3 >", value, "pressure3");
            return (Criteria) this;
        }

        public Criteria andPressure3GreaterThanOrEqualTo(String value) {
            addCriterion("pressure3 >=", value, "pressure3");
            return (Criteria) this;
        }

        public Criteria andPressure3LessThan(String value) {
            addCriterion("pressure3 <", value, "pressure3");
            return (Criteria) this;
        }

        public Criteria andPressure3LessThanOrEqualTo(String value) {
            addCriterion("pressure3 <=", value, "pressure3");
            return (Criteria) this;
        }

        public Criteria andPressure3Like(String value) {
            addCriterion("pressure3 like", value, "pressure3");
            return (Criteria) this;
        }

        public Criteria andPressure3NotLike(String value) {
            addCriterion("pressure3 not like", value, "pressure3");
            return (Criteria) this;
        }

        public Criteria andPressure3In(List<String> values) {
            addCriterion("pressure3 in", values, "pressure3");
            return (Criteria) this;
        }

        public Criteria andPressure3NotIn(List<String> values) {
            addCriterion("pressure3 not in", values, "pressure3");
            return (Criteria) this;
        }

        public Criteria andPressure3Between(String value1, String value2) {
            addCriterion("pressure3 between", value1, value2, "pressure3");
            return (Criteria) this;
        }

        public Criteria andPressure3NotBetween(String value1, String value2) {
            addCriterion("pressure3 not between", value1, value2, "pressure3");
            return (Criteria) this;
        }

        public Criteria andPressure4IsNull() {
            addCriterion("pressure4 is null");
            return (Criteria) this;
        }

        public Criteria andPressure4IsNotNull() {
            addCriterion("pressure4 is not null");
            return (Criteria) this;
        }

        public Criteria andPressure4EqualTo(String value) {
            addCriterion("pressure4 =", value, "pressure4");
            return (Criteria) this;
        }

        public Criteria andPressure4NotEqualTo(String value) {
            addCriterion("pressure4 <>", value, "pressure4");
            return (Criteria) this;
        }

        public Criteria andPressure4GreaterThan(String value) {
            addCriterion("pressure4 >", value, "pressure4");
            return (Criteria) this;
        }

        public Criteria andPressure4GreaterThanOrEqualTo(String value) {
            addCriterion("pressure4 >=", value, "pressure4");
            return (Criteria) this;
        }

        public Criteria andPressure4LessThan(String value) {
            addCriterion("pressure4 <", value, "pressure4");
            return (Criteria) this;
        }

        public Criteria andPressure4LessThanOrEqualTo(String value) {
            addCriterion("pressure4 <=", value, "pressure4");
            return (Criteria) this;
        }

        public Criteria andPressure4Like(String value) {
            addCriterion("pressure4 like", value, "pressure4");
            return (Criteria) this;
        }

        public Criteria andPressure4NotLike(String value) {
            addCriterion("pressure4 not like", value, "pressure4");
            return (Criteria) this;
        }

        public Criteria andPressure4In(List<String> values) {
            addCriterion("pressure4 in", values, "pressure4");
            return (Criteria) this;
        }

        public Criteria andPressure4NotIn(List<String> values) {
            addCriterion("pressure4 not in", values, "pressure4");
            return (Criteria) this;
        }

        public Criteria andPressure4Between(String value1, String value2) {
            addCriterion("pressure4 between", value1, value2, "pressure4");
            return (Criteria) this;
        }

        public Criteria andPressure4NotBetween(String value1, String value2) {
            addCriterion("pressure4 not between", value1, value2, "pressure4");
            return (Criteria) this;
        }

        public Criteria andPressure5IsNull() {
            addCriterion("pressure5 is null");
            return (Criteria) this;
        }

        public Criteria andPressure5IsNotNull() {
            addCriterion("pressure5 is not null");
            return (Criteria) this;
        }

        public Criteria andPressure5EqualTo(String value) {
            addCriterion("pressure5 =", value, "pressure5");
            return (Criteria) this;
        }

        public Criteria andPressure5NotEqualTo(String value) {
            addCriterion("pressure5 <>", value, "pressure5");
            return (Criteria) this;
        }

        public Criteria andPressure5GreaterThan(String value) {
            addCriterion("pressure5 >", value, "pressure5");
            return (Criteria) this;
        }

        public Criteria andPressure5GreaterThanOrEqualTo(String value) {
            addCriterion("pressure5 >=", value, "pressure5");
            return (Criteria) this;
        }

        public Criteria andPressure5LessThan(String value) {
            addCriterion("pressure5 <", value, "pressure5");
            return (Criteria) this;
        }

        public Criteria andPressure5LessThanOrEqualTo(String value) {
            addCriterion("pressure5 <=", value, "pressure5");
            return (Criteria) this;
        }

        public Criteria andPressure5Like(String value) {
            addCriterion("pressure5 like", value, "pressure5");
            return (Criteria) this;
        }

        public Criteria andPressure5NotLike(String value) {
            addCriterion("pressure5 not like", value, "pressure5");
            return (Criteria) this;
        }

        public Criteria andPressure5In(List<String> values) {
            addCriterion("pressure5 in", values, "pressure5");
            return (Criteria) this;
        }

        public Criteria andPressure5NotIn(List<String> values) {
            addCriterion("pressure5 not in", values, "pressure5");
            return (Criteria) this;
        }

        public Criteria andPressure5Between(String value1, String value2) {
            addCriterion("pressure5 between", value1, value2, "pressure5");
            return (Criteria) this;
        }

        public Criteria andPressure5NotBetween(String value1, String value2) {
            addCriterion("pressure5 not between", value1, value2, "pressure5");
            return (Criteria) this;
        }

        public Criteria andPressure6IsNull() {
            addCriterion("pressure6 is null");
            return (Criteria) this;
        }

        public Criteria andPressure6IsNotNull() {
            addCriterion("pressure6 is not null");
            return (Criteria) this;
        }

        public Criteria andPressure6EqualTo(String value) {
            addCriterion("pressure6 =", value, "pressure6");
            return (Criteria) this;
        }

        public Criteria andPressure6NotEqualTo(String value) {
            addCriterion("pressure6 <>", value, "pressure6");
            return (Criteria) this;
        }

        public Criteria andPressure6GreaterThan(String value) {
            addCriterion("pressure6 >", value, "pressure6");
            return (Criteria) this;
        }

        public Criteria andPressure6GreaterThanOrEqualTo(String value) {
            addCriterion("pressure6 >=", value, "pressure6");
            return (Criteria) this;
        }

        public Criteria andPressure6LessThan(String value) {
            addCriterion("pressure6 <", value, "pressure6");
            return (Criteria) this;
        }

        public Criteria andPressure6LessThanOrEqualTo(String value) {
            addCriterion("pressure6 <=", value, "pressure6");
            return (Criteria) this;
        }

        public Criteria andPressure6Like(String value) {
            addCriterion("pressure6 like", value, "pressure6");
            return (Criteria) this;
        }

        public Criteria andPressure6NotLike(String value) {
            addCriterion("pressure6 not like", value, "pressure6");
            return (Criteria) this;
        }

        public Criteria andPressure6In(List<String> values) {
            addCriterion("pressure6 in", values, "pressure6");
            return (Criteria) this;
        }

        public Criteria andPressure6NotIn(List<String> values) {
            addCriterion("pressure6 not in", values, "pressure6");
            return (Criteria) this;
        }

        public Criteria andPressure6Between(String value1, String value2) {
            addCriterion("pressure6 between", value1, value2, "pressure6");
            return (Criteria) this;
        }

        public Criteria andPressure6NotBetween(String value1, String value2) {
            addCriterion("pressure6 not between", value1, value2, "pressure6");
            return (Criteria) this;
        }

        public Criteria andAvgPressureIsNull() {
            addCriterion("avgPressure is null");
            return (Criteria) this;
        }

        public Criteria andAvgPressureIsNotNull() {
            addCriterion("avgPressure is not null");
            return (Criteria) this;
        }

        public Criteria andAvgPressureEqualTo(String value) {
            addCriterion("avgPressure =", value, "avgPressure");
            return (Criteria) this;
        }

        public Criteria andAvgPressureNotEqualTo(String value) {
            addCriterion("avgPressure <>", value, "avgPressure");
            return (Criteria) this;
        }

        public Criteria andAvgPressureGreaterThan(String value) {
            addCriterion("avgPressure >", value, "avgPressure");
            return (Criteria) this;
        }

        public Criteria andAvgPressureGreaterThanOrEqualTo(String value) {
            addCriterion("avgPressure >=", value, "avgPressure");
            return (Criteria) this;
        }

        public Criteria andAvgPressureLessThan(String value) {
            addCriterion("avgPressure <", value, "avgPressure");
            return (Criteria) this;
        }

        public Criteria andAvgPressureLessThanOrEqualTo(String value) {
            addCriterion("avgPressure <=", value, "avgPressure");
            return (Criteria) this;
        }

        public Criteria andAvgPressureLike(String value) {
            addCriterion("avgPressure like", value, "avgPressure");
            return (Criteria) this;
        }

        public Criteria andAvgPressureNotLike(String value) {
            addCriterion("avgPressure not like", value, "avgPressure");
            return (Criteria) this;
        }

        public Criteria andAvgPressureIn(List<String> values) {
            addCriterion("avgPressure in", values, "avgPressure");
            return (Criteria) this;
        }

        public Criteria andAvgPressureNotIn(List<String> values) {
            addCriterion("avgPressure not in", values, "avgPressure");
            return (Criteria) this;
        }

        public Criteria andAvgPressureBetween(String value1, String value2) {
            addCriterion("avgPressure between", value1, value2, "avgPressure");
            return (Criteria) this;
        }

        public Criteria andAvgPressureNotBetween(String value1, String value2) {
            addCriterion("avgPressure not between", value1, value2, "avgPressure");
            return (Criteria) this;
        }

        public Criteria andFlexure1IsNull() {
            addCriterion("flexure1 is null");
            return (Criteria) this;
        }

        public Criteria andFlexure1IsNotNull() {
            addCriterion("flexure1 is not null");
            return (Criteria) this;
        }

        public Criteria andFlexure1EqualTo(String value) {
            addCriterion("flexure1 =", value, "flexure1");
            return (Criteria) this;
        }

        public Criteria andFlexure1NotEqualTo(String value) {
            addCriterion("flexure1 <>", value, "flexure1");
            return (Criteria) this;
        }

        public Criteria andFlexure1GreaterThan(String value) {
            addCriterion("flexure1 >", value, "flexure1");
            return (Criteria) this;
        }

        public Criteria andFlexure1GreaterThanOrEqualTo(String value) {
            addCriterion("flexure1 >=", value, "flexure1");
            return (Criteria) this;
        }

        public Criteria andFlexure1LessThan(String value) {
            addCriterion("flexure1 <", value, "flexure1");
            return (Criteria) this;
        }

        public Criteria andFlexure1LessThanOrEqualTo(String value) {
            addCriterion("flexure1 <=", value, "flexure1");
            return (Criteria) this;
        }

        public Criteria andFlexure1Like(String value) {
            addCriterion("flexure1 like", value, "flexure1");
            return (Criteria) this;
        }

        public Criteria andFlexure1NotLike(String value) {
            addCriterion("flexure1 not like", value, "flexure1");
            return (Criteria) this;
        }

        public Criteria andFlexure1In(List<String> values) {
            addCriterion("flexure1 in", values, "flexure1");
            return (Criteria) this;
        }

        public Criteria andFlexure1NotIn(List<String> values) {
            addCriterion("flexure1 not in", values, "flexure1");
            return (Criteria) this;
        }

        public Criteria andFlexure1Between(String value1, String value2) {
            addCriterion("flexure1 between", value1, value2, "flexure1");
            return (Criteria) this;
        }

        public Criteria andFlexure1NotBetween(String value1, String value2) {
            addCriterion("flexure1 not between", value1, value2, "flexure1");
            return (Criteria) this;
        }

        public Criteria andFlexure2IsNull() {
            addCriterion("flexure2 is null");
            return (Criteria) this;
        }

        public Criteria andFlexure2IsNotNull() {
            addCriterion("flexure2 is not null");
            return (Criteria) this;
        }

        public Criteria andFlexure2EqualTo(String value) {
            addCriterion("flexure2 =", value, "flexure2");
            return (Criteria) this;
        }

        public Criteria andFlexure2NotEqualTo(String value) {
            addCriterion("flexure2 <>", value, "flexure2");
            return (Criteria) this;
        }

        public Criteria andFlexure2GreaterThan(String value) {
            addCriterion("flexure2 >", value, "flexure2");
            return (Criteria) this;
        }

        public Criteria andFlexure2GreaterThanOrEqualTo(String value) {
            addCriterion("flexure2 >=", value, "flexure2");
            return (Criteria) this;
        }

        public Criteria andFlexure2LessThan(String value) {
            addCriterion("flexure2 <", value, "flexure2");
            return (Criteria) this;
        }

        public Criteria andFlexure2LessThanOrEqualTo(String value) {
            addCriterion("flexure2 <=", value, "flexure2");
            return (Criteria) this;
        }

        public Criteria andFlexure2Like(String value) {
            addCriterion("flexure2 like", value, "flexure2");
            return (Criteria) this;
        }

        public Criteria andFlexure2NotLike(String value) {
            addCriterion("flexure2 not like", value, "flexure2");
            return (Criteria) this;
        }

        public Criteria andFlexure2In(List<String> values) {
            addCriterion("flexure2 in", values, "flexure2");
            return (Criteria) this;
        }

        public Criteria andFlexure2NotIn(List<String> values) {
            addCriterion("flexure2 not in", values, "flexure2");
            return (Criteria) this;
        }

        public Criteria andFlexure2Between(String value1, String value2) {
            addCriterion("flexure2 between", value1, value2, "flexure2");
            return (Criteria) this;
        }

        public Criteria andFlexure2NotBetween(String value1, String value2) {
            addCriterion("flexure2 not between", value1, value2, "flexure2");
            return (Criteria) this;
        }

        public Criteria andFlexure3IsNull() {
            addCriterion("flexure3 is null");
            return (Criteria) this;
        }

        public Criteria andFlexure3IsNotNull() {
            addCriterion("flexure3 is not null");
            return (Criteria) this;
        }

        public Criteria andFlexure3EqualTo(String value) {
            addCriterion("flexure3 =", value, "flexure3");
            return (Criteria) this;
        }

        public Criteria andFlexure3NotEqualTo(String value) {
            addCriterion("flexure3 <>", value, "flexure3");
            return (Criteria) this;
        }

        public Criteria andFlexure3GreaterThan(String value) {
            addCriterion("flexure3 >", value, "flexure3");
            return (Criteria) this;
        }

        public Criteria andFlexure3GreaterThanOrEqualTo(String value) {
            addCriterion("flexure3 >=", value, "flexure3");
            return (Criteria) this;
        }

        public Criteria andFlexure3LessThan(String value) {
            addCriterion("flexure3 <", value, "flexure3");
            return (Criteria) this;
        }

        public Criteria andFlexure3LessThanOrEqualTo(String value) {
            addCriterion("flexure3 <=", value, "flexure3");
            return (Criteria) this;
        }

        public Criteria andFlexure3Like(String value) {
            addCriterion("flexure3 like", value, "flexure3");
            return (Criteria) this;
        }

        public Criteria andFlexure3NotLike(String value) {
            addCriterion("flexure3 not like", value, "flexure3");
            return (Criteria) this;
        }

        public Criteria andFlexure3In(List<String> values) {
            addCriterion("flexure3 in", values, "flexure3");
            return (Criteria) this;
        }

        public Criteria andFlexure3NotIn(List<String> values) {
            addCriterion("flexure3 not in", values, "flexure3");
            return (Criteria) this;
        }

        public Criteria andFlexure3Between(String value1, String value2) {
            addCriterion("flexure3 between", value1, value2, "flexure3");
            return (Criteria) this;
        }

        public Criteria andFlexure3NotBetween(String value1, String value2) {
            addCriterion("flexure3 not between", value1, value2, "flexure3");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureIsNull() {
            addCriterion("avgFlexure is null");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureIsNotNull() {
            addCriterion("avgFlexure is not null");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureEqualTo(String value) {
            addCriterion("avgFlexure =", value, "avgFlexure");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureNotEqualTo(String value) {
            addCriterion("avgFlexure <>", value, "avgFlexure");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureGreaterThan(String value) {
            addCriterion("avgFlexure >", value, "avgFlexure");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureGreaterThanOrEqualTo(String value) {
            addCriterion("avgFlexure >=", value, "avgFlexure");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureLessThan(String value) {
            addCriterion("avgFlexure <", value, "avgFlexure");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureLessThanOrEqualTo(String value) {
            addCriterion("avgFlexure <=", value, "avgFlexure");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureLike(String value) {
            addCriterion("avgFlexure like", value, "avgFlexure");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureNotLike(String value) {
            addCriterion("avgFlexure not like", value, "avgFlexure");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureIn(List<String> values) {
            addCriterion("avgFlexure in", values, "avgFlexure");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureNotIn(List<String> values) {
            addCriterion("avgFlexure not in", values, "avgFlexure");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureBetween(String value1, String value2) {
            addCriterion("avgFlexure between", value1, value2, "avgFlexure");
            return (Criteria) this;
        }

        public Criteria andAvgFlexureNotBetween(String value1, String value2) {
            addCriterion("avgFlexure not between", value1, value2, "avgFlexure");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
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