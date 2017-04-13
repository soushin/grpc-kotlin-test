all: client server

deps:
	@echo "--> Resolve Dependencies"
	go get -u github.com/grpc-ecosystem/grpc-gateway/protoc-gen-grpc-gateway
	go get -u github.com/grpc-ecosystem/grpc-gateway/protoc-gen-swagger
	go get -u github.com/golang/protobuf/protoc-gen-go
	@echo ""

generate-proto:
	@echo "--> Generating Proto"
	cp protobuf/*/*.proto server/grpc-server/src/main/proto/ && cd server/grpc-server/ && gradle clean generateProto
	cp protobuf/*/*.proto client/grpc-client/src/main/proto/ && cd client/grpc-client/ && gradle clean generateProto
	protoc -I/usr/local/include -I. \
  -I$(GOPATH)/src \
  -I$(GOPATH)/src/github.com/grpc-ecosystem/grpc-gateway/third_party/googleapis \
  --go_out=plugins=grpc:. \
  protobuf/echo/echo.proto
	protoc -I/usr/local/include -I. \
  -I$(GOPATH)/src \
  -I$(GOPATH)/src/github.com/grpc-ecosystem/grpc-gateway/third_party/googleapis \
  --go_out=plugins=grpc:. \
  protobuf/greet/greet.proto
	@echo ""

generate-grpc-gateway:
	@echo "--> Generating gRPC-gateway"
	protoc -I/usr/local/include -I. \
  -I$(GOPATH)/src \
  -I$(GOPATH)/src/github.com/grpc-ecosystem/grpc-gateway/third_party/googleapis \
  --grpc-gateway_out=logtostderr=true:. \
  protobuf/echo/echo.proto 
	protoc -I/usr/local/include -I. \
  -I$(GOPATH)/src \
  -I$(GOPATH)/src/github.com/grpc-ecosystem/grpc-gateway/third_party/googleapis \
  --grpc-gateway_out=logtostderr=true:. \
  protobuf/greet/greet.proto 
	@echo ""
