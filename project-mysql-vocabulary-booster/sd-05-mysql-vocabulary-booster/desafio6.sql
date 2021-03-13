SELECT
CONCAT(E.FIRST_NAME, ' ', E.LAST_NAME) `Nome completo`,
J.JOB_TITLE Cargo,
JH.START_DATE `Data de início do cargo`,
D.DEPARTMENT_NAME Departamento
FROM hr.job_history AS JH
INNER JOIN hr.jobs as J
ON JH.JOB_ID = J.JOB_ID
INNER JOIN hr.employees AS E
ON JH.EMPLOYEE_ID = E.EMPLOYEE_ID
INNER JOIN hr.departments AS D
ON JH.DEPARTMENT_ID = D.DEPARTMENT_ID
ORDER BY `Nome completo` DESC, Cargo;
