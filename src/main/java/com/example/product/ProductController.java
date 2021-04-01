package com.example.product;

import com.example.product.Consultant;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( origins = "http://hybrid-cloud-team-cinq-git-ucllteam05.ocp-ucll-40cb0df2b03969eabb3fac6e80373775-0000.eu-de.containers.appdomain.cloud", allowCredentials = "true")
@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Consultant> getAllConsultants() {
        System.out.println("???");

        return Arrays.asList(
                //new Consultant("1", "Milos Fungate", "Hello, my name is Milos and I provide blockchain consulting services. With several years developing blockchain solutions, as well as regular software development, I was able to cover a lot of terrain concerning different types of blockchain systems. Furthermore, I've received my MSc in the area of blockchain and information technologies. If you need a general architecture, or an overview, look no further - we're bound to make something happen", "https://miro.medium.com/max/2800/1*w96ZU0M9GOAGU_hVXvdH8g.jpeg", 50),
                //new Consultant("2", "Ryan G", "Licensed CPA with 5 years experience in audit and transaction services for Big 4 Firm. Controller and CFO for a large number of startup companies. Skills include expertise in GAAP and IFRS accounting, financial management and planning, CFO and fundraising services, and due diligence. Vast knowledge of Quickbooks, Xero, Netsuite, SAP, Gusto, Paychex, Expensify, and others. Services include bookkeeping, accounting management and controller services, payroll, A/P, A/R, CFO services, financial planning, fundraising, taxes, and business consulting.", "https://www.pngkey.com/png/detail/400-4000020_some-random-guy-photograph.png", 45),
                new Consultant("3", "Chloe W", "I'm a Creative, skilled and accomplished Content Writer with diverse knowledge of writing contents for various websites." , "As a full-time writer and editor, I've made a career of polishing others' content. I work with clients ranging from hospitals, Tech firms, and law firms, , to artists and building companies, and ensure everything they publish hits the mark As a former Bloomberg affiliate reporter, I have a knack for writing from others' perspectives.If we work together, I will help you...", "https://randomuser.me/api/portraits/women/94.jpg", 40),
                new Consultant("4", "Faruk K", "Bachelor's degree in information security, computer science." , "Specialized in blockchaintechnology and a professional cyrpto analyst. Bachelor's degree in information security, computer science. Specialized in blockchaintechnology and a professional cyrpto analyst.", "https://randomuser.me/api/portraits/men/61.jpg", 65),
                new Consultant("5", "Ryan G", "I am software developer and consultant in the area of Ethereum, Smart Contract development.", "Contact me if you would like me to work on ICO or Smart Contract development. You can also send me a message if you feel a little lost in new world of Smart Contract Development. Currently I work only as a Solidity Ethereum Developer and Consultant.", "https://www.upwork.com/profile-portraits/c1_A2tVq_ADFMWEIF5EeSi45lujtAUe2A9coDDzRSQWJzpACrAClZy81QjPE8vw0Zm", 60),
                new Consultant("6",  "Stefan C","I am a computer scientist with a background in Distributed Systems research and cybersecurity (more than 20 years).", "I hold a Ph.D. in Computer Science from the University of Manchester (United Kingdom). My current freelance activities focus on blockchain consulting and technical writing. I offer smart contract audits, blockchain architecture design and technical writing.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEQwyipIfncjOFxEr-Ziy1HemWB4oOPxNK4g&usqp=CAU", 70),
                new Consultant("7", "Konstantin S" , "I'm a Fintech / DeFi consultant with more than 12 years of experience, so you can describe me as a qualified analyst in banking & finance.", "I also worked on the development and on improvement and architecture design of a wide range of complex financial IT systems. Several years ago I've discovered blockchain and got very excited about this new technology that was innovative and ambitious.", "https://randomuser.me/api/portraits/men/18.jpg", 85),
                new Consultant("8", "Michael K", "Successful entrepreneur and business builder with specific commercial expertise in trading, risk management, physical commodities, renewables.", "Have been member of leadership team in multiple greater than $100M P/L companies. Hands-on, direct development experience with data analysis, blockchain, product management, and software development. Additional deep expertise in databases, Excel, business modeling, algorithms, and automation.", "https://randomuser.me/api/portraits/men/32.jpg", 70)

        );
    }

    @GetMapping("/check")
    public boolean greeting(@RequestParam(value = "name", defaultValue = "World") String name,
                            @AuthenticationPrincipal Jwt accessToken) {
        System.out.println("In GET Request");
        String scope = accessToken.getClaims().get("scope").toString();
        Boolean partnerRole = scope.contains("partner");
        System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString());
        System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString().contains("partner"));
        if (partnerRole) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/consultants")
    public String addProduct(@RequestBody Consultant consultant, @AuthenticationPrincipal Jwt accessToken) {
        System.out.println("In POST Request");
        String scope = accessToken.getClaims().get("scope").toString();
        Boolean partnerRole = scope.contains("partner");

        if (partnerRole) {
            System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString());
            System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString().contains("partner"));
            return "Product added";
        } else {
            return "Not Authorized to add product";
        }
    }

    @GetMapping("/hiredConsultants/{id}")
    public Consultant hiredConsultants(@PathVariable("id") String id) {
        List<Consultant> consultants =  this.getAllConsultants();

        Consultant consultant = consultants.get(Integer.parseInt(id) - 1);

        return consultant;
    }

}