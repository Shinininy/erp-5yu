package com.sunline.vuedemo.controller;

import com.sunline.vuedemo.vo.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/static_data")
@CrossOrigin
public class StaticDataController {
    @GetMapping("/country_search")
    public ResponseEntity<String> findCountryNameByCode(@RequestParam(required = false) String code) {
        // 如果code为空或者是空字符串，返回空响应
        if (code == null || code.trim().isEmpty()) {
            return ResponseEntity.ok(""); // 返回空响应
        }

        Country country = Country.findByCode(code);
        if (country != null) {
            return ResponseEntity.ok(country.getName());
        } else {
            return ResponseEntity.badRequest().body("");
        }
    }

        @GetMapping("/country_list")
    public ResponseEntity<List<String>> listCountries() {
        // 使用Java 8 Stream API获取所有的国家名称
        List<String> countries = Arrays.stream(Country.values())
                .map(Country::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/salesOrg_search")
    public ResponseEntity<String> findSalesOrgByCode(@RequestParam(required = false) String code) {
        if (code == null || code.trim().isEmpty()) {
            return ResponseEntity.ok("");
        }

        SalesOrg org = SalesOrg.findByCode(code);
        if (org != null) {
            return ResponseEntity.ok(org.getDescription());
        } else {
            return ResponseEntity.badRequest().body("");
        }
    }

    @GetMapping("/salesOrg_list")
    public ResponseEntity<List<String>> listSalesOrgs() {
        List<String> orgs = Arrays.stream(SalesOrg.values())
                .map(SalesOrg::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(orgs);
    }

    @GetMapping("/cl_search")
    public ResponseEntity<String> findDistrChannelByCode(@RequestParam(required = false) String code) {
        if (code == null || code.trim().isEmpty()) {
            return ResponseEntity.ok("");
        }

        DistrChannel channel = DistrChannel.findByCode(code);
        if (channel != null) {
            return ResponseEntity.ok(channel.getName());
        } else {
            return ResponseEntity.badRequest().body("");
        }
    }

    @GetMapping("/cl_list")
    public ResponseEntity<List<String>> listDistrChannels() {
        List<String> channels = Arrays.stream(DistrChannel.values())
                .map(DistrChannel::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(channels);
    }

    @GetMapping("/currency_search")
    public ResponseEntity<String> findCurrencyByCode(@RequestParam(required = false) String code) {
        if (code == null || code.trim().isEmpty()) {
            return ResponseEntity.ok("");
        }

        Currency currency = Currency.findByCode(code);
        if (currency != null) {
            return ResponseEntity.ok(currency.getDescription());
        } else {
            return ResponseEntity.badRequest().body("");
        }
    }

    @GetMapping("/currency_list")
    public ResponseEntity<List<String>> listCurrencies() {
        List<String> currencies = Arrays.stream(Currency.values())
                .map(Currency::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(currencies);
    }

    @GetMapping("/company_search")
    public ResponseEntity<String> findCompanyNameByCode(@RequestParam(required = false) String code) {
        if (code == null || code.trim().isEmpty()) {
            return ResponseEntity.ok("");
        }

        CompanyCode companyCode = CompanyCode.findByCode(code);
        if (companyCode != null) {
            return ResponseEntity.ok(companyCode.getName());
        } else {
            return ResponseEntity.badRequest().body("");
        }
    }

    @GetMapping("/company_list")
    public ResponseEntity<List<String>> listCompanyCodes() {
        List<String> codes = Arrays.stream(CompanyCode.values())
                .map(CompanyCode::name)
                .collect(Collectors.toList());
        return ResponseEntity.ok(codes);
    }
}
