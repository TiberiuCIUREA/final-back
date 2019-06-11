package com.tiberiu.mentool.exposition.user;

import com.tiberiu.mentool.domain.user.EmailAddress;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailAddressJsonCombinedSerializerTest {

    @Test
    public void test_serializer() throws JsonProcessingException {
        String randomRawAddress = "tiberiu.ciurea@test.com";
        String serializedAddress = new ObjectMapper().writeValueAsString(new EmailAddress(randomRawAddress));
        System.out.println(serializedAddress);
        assertThat(serializedAddress).isEqualTo("\"" + randomRawAddress + "\"");
    }

    @Test
    public void test_deserialize() throws IOException {
        String addressRawValue = "tiberiu.ciurea@test.com";
        TestDto deserializedAddress = new ObjectMapper().readValue(
                "{\"address\":" + "\"" +  addressRawValue + "\"" + "}", TestDto.class
        );
        assertThat(deserializedAddress.address).isEqualTo(new EmailAddress(addressRawValue));
    }


    private static class TestDto {
        @JsonProperty
        EmailAddress address;
    }
}
