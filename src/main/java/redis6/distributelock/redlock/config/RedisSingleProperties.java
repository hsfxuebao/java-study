package redis6.distributelock.redlock.config;

import lombok.Data;

@Data
public class RedisSingleProperties {
    private  String address1;
    private  String address2;
    private  String address3;
}