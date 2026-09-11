package com.mpkmb.configuration;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(
  info = @Info(
    title = "ms-quarkus Basic API",
    version = "1.0.0",
    description = "Basic API"
  )
)

public class OpenApiConfig {
}