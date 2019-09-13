package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.example.demo.Interface.TrosakJpaRepository;
import com.example.demo.Interface.TrosakRepository;

public class Job extends QuartzJobBean{


	@Autowired
	TrosakRepository trosakRepository;
	
	@Autowired
	TrosakJpaRepository trosakJpaRepository;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
	
		List<Object[]> lista = trosakJpaRepository.dohvatiPodatkeStatistika();
		
		System.out.println(lista.size());
		
		System.out.println("VRSTA   SUM    MIN    MAX");
        for(int i = 0; i < lista.size(); i++) {
           Object[] line = lista.get(i);
            System.out.print(line[0]);
            System.out.print("  ");
            System.out.print(line[1]);
            System.out.print("  ");
            System.out.print(line[2]);
            System.out.print("  ");
            System.out.println(line[3]);
           
        }
      
        
	
	
	}



}
