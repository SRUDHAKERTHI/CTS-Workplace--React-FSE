SET SERVEROUTPUT ON;

DECLARE
    marks NUMBER := 78;
    grade CHAR(1);
    day_num NUMBER := 3;
    day_name VARCHAR2(20);
BEGIN

    IF marks >= 90 THEN
        grade := 'A';
    ELSIF marks >= 75 THEN
        grade := 'B';
    ELSIF marks >= 50 THEN
        grade := 'C';
    ELSE
        grade := 'F';
    END IF;

    DBMS_OUTPUT.PUT_LINE('Marks: ' || marks || ' -> Grade: ' || grade);

   
    CASE day_num
        WHEN 1 THEN day_name := 'Monday';
        WHEN 2 THEN day_name := 'Tuesday';
        WHEN 3 THEN day_name := 'Wednesday';
        WHEN 4 THEN day_name := 'Thursday';
        WHEN 5 THEN day_name := 'Friday';
        ELSE day_name := 'Weekend';
    END CASE;

    DBMS_OUTPUT.PUT_LINE('Day number ' || day_num || ' -> ' || day_name);

    
    DBMS_OUTPUT.PUT_LINE('Multiples of 3:');
    FOR i IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(i * 3);
    END LOOP;
END;
/