package com.example.caffeinecachedemo.dns.web;

import com.example.caffeinecachedemo.dns.domain.DnsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dns")
public class DnsController {

    private final DnsService dnsService;

    public DnsController(DnsService dnsService) {
        this.dnsService = dnsService;
    }

    @GetMapping("/{domain}")
    public String resolve(@PathVariable("domain") String domain) {
        return dnsService.resolve(domain);
    }
}
