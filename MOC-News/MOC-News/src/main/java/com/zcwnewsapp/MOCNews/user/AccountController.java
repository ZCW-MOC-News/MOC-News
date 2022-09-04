package com.zcwnewsapp.MOCNews.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Controller
@RequestMapping(path="/accounts") // This means URL's start with /accounts (after Application path)
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String username
            , @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Account n = new Account();
        n.setUsername(username);
        String encrypted = BCrypt.hashpw(password, BCrypt.gensalt());
        n.setPassword(encrypted);
        entityManager.persist(n);
        accountRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Account> getAllAccounts() {
        //     This returns a JSON or XML with the users
        return accountRepository.findAll();
    }

    @GetMapping(path="/find_id")
    public @ResponseBody Optional<Account> getAccount(@RequestParam Long id) {

        return accountRepository.findById(id);
    }

    @GetMapping(path="/find")
    public @ResponseBody Optional<Account> getAccount(@RequestParam String username) {
        return accountRepository.findByUsername(username);
    }
}