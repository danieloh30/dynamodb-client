package org.acme;

import java.util.HashMap;
import java.util.Map;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

public class AbstractService {

    public static final String PERSON_NAME_COL = "name";
    public static final String PERSON_ADDR_COL = "addr";

    public String getTableNmae() {
        return "person";
    }

    public ScanRequest scanRequest() {
        return ScanRequest.builder().tableName(getTableNmae())
            .attributesToGet(PERSON_NAME_COL, PERSON_ADDR_COL).build();
    }

    public PutItemRequest putItemRequest(Person person) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put(PERSON_NAME_COL, AttributeValue.builder().s(person.getName()).build());
        item.put(PERSON_ADDR_COL, AttributeValue.builder().s(person.getAddr()).build());
        return PutItemRequest.builder().tableName(getTableNmae())
            .item(item).build();
    }
    
}
