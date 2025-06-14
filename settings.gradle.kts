rootProject.name = "my-demos"

include(":rabbitmq")
include("guice-grpc-jersey")
include("java-native")
include(":instrumentation")

project(":instrumentation").projectDir = file("java-core/instrumentation")
include("reactjs")
include("reactjs")
