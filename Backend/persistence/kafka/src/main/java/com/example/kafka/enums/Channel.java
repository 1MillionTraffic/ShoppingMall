package com.example.kafka.enums;

public enum Channel {
    TEST_CHANNEL_1("test_topic_1"),
    TEST_CHANNEL_2("test_topic_2"),
    CREATE_ORDER("create_order");

    private final String name;

    Channel(String name){this.name = name;}

    public String GetChannelName(){return this.name;}
}
