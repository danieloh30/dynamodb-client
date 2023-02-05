package org.acme;

import java.util.Map;

import io.quarkus.runtime.annotations.RegisterForReflection;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

@RegisterForReflection
public class Person {

    public String name;
    public String addr;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return this.addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Person() {}

    public static Person from(Map<String, AttributeValue> item) {
        Person person = new Person();
        if (item != null && !item.isEmpty()) {
            // TODO : Setting Attributes
            person.setName(item.get(AbstractService.PERSON_NAME_COL).s());
            person.setAddr(item.get(AbstractService.PERSON_ADDR_COL).s());
        }
        return person;
    }
    
}
