package com.example.furama.controller;

import com.example.furama.dto.ContractDetailCreateResponseDto;
import com.example.furama.model.ContractDetail;
import com.example.furama.service.IAttachServiceService;
import com.example.furama.service.IContractDetailService;
import com.example.furama.service.IContractService;
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
@RequestMapping("/contract-detail")
public class ContractDetailController {
    private final IContractDetailService iContractDetailService;
    private final IContractService iContractService;
    private final IAttachServiceService iAttachServiceService;

    public ContractDetailController(IContractDetailService iContractDetailService, IContractService iContractService, IAttachServiceService iAttachServiceService) {
        this.iContractDetailService = iContractDetailService;
        this.iContractService = iContractService;
        this.iAttachServiceService = iAttachServiceService;
    }

    @GetMapping("")
    public String list(@PageableDefault(size = 2) Pageable pageable, String search, Model model) {
        Page<ContractDetail> contractDetails = iContractDetailService.findAll(pageable);
        model.addAttribute("contractDetails", contractDetails);

        List<Integer> pageNumbers = IntStream.rangeClosed(1, contractDetails.getTotalPages())
                .boxed()
                .collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        return "contractDetail/list";
    }

    @GetMapping("/show-create")
    public String showCreate(Model model) {
        ContractDetailCreateResponseDto contractDetailCreateResponseDto = ContractDetailCreateResponseDto.builder()
                .contractIdList(iContractService.findAllContractId())
                .attachServiceIdList(iAttachServiceService.findAllAttachServiceId())
                .build();

        model.addAttribute("contractDetailCreateResponseDto", contractDetailCreateResponseDto);
        model.addAttribute("contractDetail", ContractDetail.builder().build());
        return "contractDetail/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("contractDetail") ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        iContractDetailService.save(contractDetail);

        redirectAttributes.addFlashAttribute("message", "Thêm thành công");
        return "redirect:/contract-detail";
    }
}
