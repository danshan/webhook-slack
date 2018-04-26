package com.shanhh.webhook.integration.sonarqube.beans;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author dan
 * @since 2017-03-21 17:30
 */
@Setter
@Getter
@NoArgsConstructor
public class SonarqubePayload implements Serializable {
    /**
     * analysedAt : 2016-11-18T10:46:28+0100
     * project : {"key":"org.sonarqube:example","name":"Example"}
     * properties : {}
     * qualityGate : {"conditions":[{"errorThreshold":"1","metric":"new_security_rating","onLeakPeriod":true,"operator":"GREATER_THAN","status":"OK","value":"1"},{"errorThreshold":"1","metric":"new_reliability_rating","onLeakPeriod":true,"operator":"GREATER_THAN","status":"OK","value":"1"},{"errorThreshold":"1","metric":"new_maintainability_rating","onLeakPeriod":true,"operator":"GREATER_THAN","status":"OK","value":"1"},{"errorThreshold":"80","metric":"new_coverage","onLeakPeriod":true,"operator":"LESS_THAN","status":"NO_VALUE"}],"name":"SonarQube way","status":"OK"}
     * status : SUCCESS
     * taskId : AVh21JS2JepAEhwQ-b3u
     */

    @SerializedName("analysedAt")
    private String analysedAt;
    @SerializedName("project")
    private ProjectBean project;
    @SerializedName("properties")
    private PropertiesBean properties;
    @SerializedName("qualityGate")
    private QualityGateBean qualityGate;
    @SerializedName("status")
    private String status;
    @SerializedName("taskId")
    private String taskId;

    @Setter
    @Getter
    @NoArgsConstructor
    public static class ProjectBean {
        /**
         * key : org.sonarqube:example
         * name : Example
         */

        @SerializedName("key")
        private String key;
        @SerializedName("name")
        private String name;

    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class PropertiesBean {
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class QualityGateBean {
        /**
         * conditions : [{"errorThreshold":"1","metric":"new_security_rating","onLeakPeriod":true,"operator":"GREATER_THAN","status":"OK","value":"1"},{"errorThreshold":"1","metric":"new_reliability_rating","onLeakPeriod":true,"operator":"GREATER_THAN","status":"OK","value":"1"},{"errorThreshold":"1","metric":"new_maintainability_rating","onLeakPeriod":true,"operator":"GREATER_THAN","status":"OK","value":"1"},{"errorThreshold":"80","metric":"new_coverage","onLeakPeriod":true,"operator":"LESS_THAN","status":"NO_VALUE"}]
         * name : SonarQube way
         * status : OK
         */

        @SerializedName("name")
        private String name;
        @SerializedName("status")
        private String status;
        @SerializedName("conditions")
        private List<ConditionsBean> conditions;

        @Setter
        @Getter
        @NoArgsConstructor
        public static class ConditionsBean {
            /**
             * errorThreshold : 1
             * metric : new_security_rating
             * onLeakPeriod : true
             * operator : GREATER_THAN
             * status : OK
             * value : 1
             */

            @SerializedName("errorThreshold")
            private String errorThreshold;
            @SerializedName("metric")
            private String metric;
            @SerializedName("onLeakPeriod")
            private boolean onLeakPeriod;
            @SerializedName("operator")
            private String operator;
            @SerializedName("status")
            private String status;
            @SerializedName("value")
            private String value;

        }
    }

}
