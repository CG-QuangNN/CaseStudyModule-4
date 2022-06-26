package com.example.furama.controller;

import com.example.furama.model.Customer;
import com.example.furama.model.CustomerType;
import com.example.furama.service.ICustomerService;
import com.example.furama.service.ICustomerTypeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final ICustomerService iCustomerService;
    private final ICustomerTypeService iCustomerTypeService;

    public CustomerController(ICustomerService iCustomerService, ICustomerTypeService iCustomerTypeService) {
        this.iCustomerService = iCustomerService;
        this.iCustomerTypeService = iCustomerTypeService;
    }

    @ModelAttribute("customerTypeList")
    List<CustomerType> getCustomerTypeList() {
        return iCustomerTypeService.findAll();
    }

    @GetMapping("")
    public String list(@PageableDefault(size = 2) Pageable pageable, String search, Model model) {
        model.addAttribute("customers", iCustomerService.findAllBySearch(search, pageable));

        List<Integer> pageNumbers = IntStream.rangeClosed(1, iCustomerService.findAllBySearch(search, pageable).getTotalPages())
                .boxed()
                .collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        return "customer/list";
    }

    @GetMapping("/show-create")
    public String showCreate(Model model) {
        model.addAttribute("customer", Customer.builder().build());

        return "customer/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);

        redirectAttributes.addFlashAttribute("message", "Thêm thành công");
        return "redirect:/customer";
    }

    @GetMapping("/show-edit")
    public String showEdit(Integer customerId, Model model) {
        model.addAttribute("customer", iCustomerService.findById(customerId).orElseThrow(NoSuchElementException::new));
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);

        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công");
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String delete(Integer customerId, RedirectAttributes redirectAttributes) {
        iCustomerService.delete(customerId);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/customer";
    }
}
