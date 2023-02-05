package org.acme;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@ApplicationScoped
public class PersonService extends AbstractService {

    @Inject
    DynamoDbClient dynamoDbClient;

    public List<Person> findAll() {
        return dynamoDbClient.scanPaginator(scanRequest()).items().stream()
            .map(Person::from)
            .collect(Collectors.toList());
    }

    public void addPerson(Person person) {
        dynamoDbClient.putItem(putItemRequest(person));
    }
    
}
