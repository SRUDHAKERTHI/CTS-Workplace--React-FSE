
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE calculate_bonus(
    p_salary   IN  NUMBER,
    p_bonus    OUT NUMBER
) IS
BEGIN
    IF p_salary >= 50000 THEN
        p_bonus := p_salary * 0.15;
    ELSIF p_salary >= 30000 THEN
        p_bonus := p_salary * 0.10;
    ELSE
        p_bonus := p_salary * 0.05;
    END IF;
END calculate_bonus;
/


DECLARE
    v_bonus NUMBER;
BEGIN
    calculate_bonus(60000, v_bonus);
    DBMS_OUTPUT.PUT_LINE('Bonus for salary 60000: ' || v_bonus);

    calculate_bonus(35000, v_bonus);
    DBMS_OUTPUT.PUT_LINE('Bonus for salary 35000: ' || v_bonus);

    calculate_bonus(20000, v_bonus);
    DBMS_OUTPUT.PUT_LINE('Bonus for salary 20000: ' || v_bonus);
END;
/