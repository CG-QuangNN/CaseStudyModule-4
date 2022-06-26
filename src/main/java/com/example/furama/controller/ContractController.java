package com.example.furama.controller;

import com.example.furama.dto.ContractCreateResponseDto;
import com.example.furama.model.Contract;
import com.example.furama.service.IContractService;
import com.example.furama.service.ICustomerService;
import com.example.furama.service.IEmployeeService;
import com.example.furama.service.IServiceService;
import org.springframework.data.domain.Page;
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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/contract")
public class ContractController {
    private final IContractService iContractService;
    private final IEmployeeService iEmployeeService;
    private final ICustomerService iCustomerService;
    private final IServiceService iServiceService;

    public ContractController(IContractService iContractService, IEmployeeService iEmployeeService, ICustomerService iCustomerService,
                              IServiceService iServiceService) {
        this.iContractService = iContractService;
        this.iEmployeeService = iEmployeeService;
        this.iCustomerService = iCustomerService;
        this.iServiceService = iServiceService;
    }

    @GetMapping("")
    public String list(@PageableDefault(size = 2) Pageable pageable, String search, Model model) {
        Page<Contract> contracts = iContractService.findAll(pageable);
        model.addAttribute("contracts", contracts);

        List<Integer> pageNumbers = IntStream.rangeClosed(1, contracts.getTotalPages())
                .boxed()
                .collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        return "contract/list";
    }

    @GetMapping("/show-create")
    public String showCreate(Model model) {
        ContractCreateResponseDto contractCreateResponseDto = ContractCreateResponseDto.builder()
                .employeeIdList(iEmployeeService.findAllEmployeeId())
                .customerIdList(iCustomerService.findAllCustomerId())
                .serviceIdCodeDtoList(iServiceService.findAllServiceIdCode())
                .build();

        model.addAttribute("contractCreateResponseDto", contractCreateResponseDto);
        model.addAttribute("contract", Contract.builder().build());
        return "contract/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes) {
        iContractService.save(contract);

        redirectAttributes.addFlashAttribute("message", "Thêm thành công");
        return "redirect:/contract";
    }
}
