package wazhu.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LeetCode_811 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_811().subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.parseInt(split[0]);
            String domain = split[1];
            map.compute(domain, (s, v) -> Objects.isNull(v) ? count : v + count);
            int index = domain.indexOf('.');
            while (index >= 0) {
                String substring = domain.substring(index + 1, domain.length());
                index = domain.indexOf('.', index + 1);
                map.compute(substring, (s, v) -> Objects.isNull(v) ? count : v + count);
            }

        }
        return map.entrySet().stream().map(e -> e.getValue() + " " + e.getKey()).collect(Collectors.toList());
    }
}
