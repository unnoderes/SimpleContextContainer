package io.unnode.beans.support;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {

    // 问题02
    final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }

    // 多属性 get
    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    // 单属性 get
    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }
}
