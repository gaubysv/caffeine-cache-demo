package com.example.caffeinecachedemo.dns.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class DnsService {

    private static final Map<String, String> MAPPING = new ConcurrentHashMap<>();

    static {
        MAPPING.put("google.com", "100.100.100.100");
        MAPPING.put("youtube.com", "200.200.200.200");
        MAPPING.put("facebook.com", "300.300.300.300");
    }

    @Cacheable("ipAddressCache")
    public String resolve(String domain) {
        log.info("Resolving {} to an IP address.", domain);

        try {
            // Simulate long operation.
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("Response from DNS for {} received.", domain);

        return MAPPING.get(domain);
    }
}
