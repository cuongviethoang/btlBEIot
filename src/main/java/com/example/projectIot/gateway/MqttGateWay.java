// gửi dữ liệu đến MQTT broker
package com.example.projectIot.gateway;

import org.springframework.integration.annotation.MessagingGateway;

import org.springframework.integration.mqtt.support.MqttHeaders;

import org.springframework.messaging.handler.annotation.Header;

// Được sử dụng để xác định kênh (channel) mặc định mà các message sẽ được
// gửi đến khi gọi phương thức trong sendToMqtt.
//  defaultRequestChannel = "mqttOutboundChannel" : khi gọi phương thức
// sendToMqtt, message được tạo ra từ cuộc
// gọi này sẽ được định tuyến đến kênh "mqttOutboundChannel"
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateWay {
    void sendToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic);
}
