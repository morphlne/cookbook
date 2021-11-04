Generating OpenApi 3.0 yaml/json
using [springdoc-openapi-webflux-ui](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-webflux-ui)
& [springdoc-openapi-maven-plugin](https://github.com/springdoc/springdoc-openapi-maven-plugin)

Plugin fetches documentation on http://localhost:8080/v3/api-docs during integration-test phase

1) endpoint should be exposed by security
2) port should be the same as running application has. Change port in `apiDocsUrl` or pass default server.port to
   spring-boot-maven-plugin start goal
3) /v3/api-docs.yaml in `apiDocsUrl` for yaml format

Press `mvn verify` to generate
