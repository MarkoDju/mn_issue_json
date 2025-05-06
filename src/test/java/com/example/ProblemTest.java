package com.example;

import io.micronaut.core.type.Argument;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.serde.ObjectMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.io.IOException;

@MicronautTest
class ProblemTest {

    @Inject
    ObjectMapper objectMapper;

    @Test
    void testGeneric() throws IOException {
        var dataTwo = DataTwo.builder().dataInt(1234).dataString("dummyString").build();
        var dataOne = DataOne.builder().dataItem(dataTwo).id(999).build();

        var json = objectMapper.writeValueAsString(dataOne);

        var obj = objectMapper.readValue(json, Argument.of(DataOne.class, DataTwo.class));

        Assertions.assertEquals(dataOne.getId(), obj.getId());

        if (obj.getDataItem() instanceof DataTwo data) {
            Assertions.assertEquals(dataTwo.getDataInt(), data.getDataInt());
            Assertions.assertEquals(dataTwo.getDataString(), data.getDataString());
        } else {
            Assertions.fail();
        }
    }

}
