package com.problem.application.config.converter

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class JsonToMapConverter : AttributeConverter<Map<String, String>?, String?> {
    val objectMapper = ObjectMapper()

    override fun convertToDatabaseColumn(attribute: Map<String, String>?): String? {
        return attribute?.let { objectMapper.writeValueAsString(it) }
    }

    override fun convertToEntityAttribute(dbData: String?): Map<String, String>? {
        if (dbData == null) {
            return null
        }

        return dbData.let { objectMapper.readValue(it, HashMap::class.java) as Map<String, String> }
    }
}