package com.josecondori.springbatch.listeners;

import com.josecondori.springbatch.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    private final JdbcTemplate jdbcTemplate;

    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("Finalized del job");
            String query = "SELECT name, lastname, dni FROM persons";
            jdbcTemplate.query(query, (rs, row) -> new Person(rs.getString(1), rs.getString(2), rs.getString(3))
                            /*Person.builder().name(rs.getString(0))
                            .lastname(rs.getString(1))
                            .dni(rs.getString(2))
                            .build()*/
                    )
                    .forEach(persons -> LOGGER.info("Found < {} > in the database.", persons));
        }
    }
}
