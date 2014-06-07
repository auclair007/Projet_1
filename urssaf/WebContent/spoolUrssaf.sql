\pset tuples_only
\pset footer off
SELECT vir_treso || occasionnel || rpad(reference, 16) || transaction || rpad(payeur, 8) || rpad(tiers, 10) || rpad(' ', 8) || rpad(devise, 3) || to_char(montant, '9999999999999999.99') || to_char(date_ope, 'ddmmyyyy') || mode_maj || rpad(' ', 3) || rpad(compte_debiter, 10) || rpad(' ', 8) || code_budget || rpad(motif, 35) || rpad(' ', 105) || rpad(texte_libre, 70) || rpad(' ', 678) || rpad(donneur_ordre, 8) || rpad(' ', 39) || '000' || mode_regl FROM decla_02 WHERE date_ope = to_date('15052014', 'ddmmyyyy') and montant > 0  ORDER BY texte_libre
