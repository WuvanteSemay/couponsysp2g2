package com.jb.couponsysp2g2.services;

import com.jb.couponsysp2g2.beans.Company;
import com.jb.couponsysp2g2.beans.Customer;
import com.jb.couponsysp2g2.exceptions.CouponSystemException;
import com.jb.couponsysp2g2.exceptions.ErrMsg;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class AdminServiceImpl extends ClientService implements AdminService{
    @Override
    public void addCompany(Company company) throws CouponSystemException {
        if (this.companyRepository.existsByEmail(company.getEmail())){
            throw new CouponSystemException(ErrMsg.COMPANY_EMAIL_EXIST);
        }

        if(this.companyRepository.existsByName(company.getName())){
            throw new CouponSystemException(ErrMsg.COMPANY_NAME_EXIST);
        }
        companyRepository.save(company);

    }

    @Override
    public void updateCompany(int companyId, Company company) throws CouponSystemException {
        if (!this.companyRepository.existsById(company.getId())){
            throw new CouponSystemException(ErrMsg.COMPANY_ID_NOT_EXIST);
        }
        companyRepository.saveAndFlush(company);

    }

    @Override
    public void deleteCompany(int companyId) throws CouponSystemException {
        if (!this.companyRepository.existsById(companyId)){
            throw new CouponSystemException(ErrMsg.COMPANY_ID_NOT_EXIST);
        }
        companyRepository.deleteById(companyId);

    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getSingleCompany(int companyId) throws CouponSystemException {
        return companyRepository.findById(companyId).orElseThrow();
    }

    @Override
    public void addCustomer(Customer customer) throws CouponSystemException {
        if (this.customerRepository.existsByEmail(customer.getEmail())){
            throw new CouponSystemException(ErrMsg.CUSTOMER_EMAIL_EXIST);
        }

        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(int customerId, Customer customer) throws CouponSystemException {
        if (this.customerRepository.existsById(customerId)){
            throw new CouponSystemException(ErrMsg.CUSTOMER_ID_EXIST);
        }

        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getSingleCustomer(int customerId) {
        return customerRepository.findById(customerId).orElseThrow();
    }

    @Override
    public boolean login(String email, String password) {
        return email.equals("admin@admin.com")&&password.equals("admin");
    }
}
