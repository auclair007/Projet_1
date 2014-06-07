<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


		        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		        <title>Paramètres</title>
		        </head>
		        <body background ="mur_du_son_2.jpg" text="yellow">
		
		        
		        <H2>Paramètres URSSAF</H2>
		        <form action="VerifExcel" method="post">
		        <table border=1>
		        <tr>
		        <td>Fichier Excel à traiter</td>
		        <td><input type="text" size="50" name="fichierexcel" value="${param.fexcel}"></td>
		        </tr>
		        <tr>
		        <td>Fichier XRT</td>
		        <td><input type="text" size="50" name="fichierxrt" value=" ${ param.fxrt2 }"></td>
		        </tr>
		        <tr>
		        <td>Nom de l'onglet</td>
		        <td><input type="text" name="ref_onglet" value=" ${ onglet } "></td>
		        </tr>
		        <tr>
		        <td>Première ligne à traiter</td>
		        <td><input type="text" name="firstligne" value=" ${ firstligne } ">3</td>
		        </tr>
		        <tr>
		        <td>Dernière ligne à traiter</td>
		        <td><input type="text" name="lastligne" value=" ${ lastligne } ">105</td>
		        </tr>
		        <tr>
		        <td>Colonne magasin</td>
		        <td><input type="text" name="colpdv" value=" ${ colpdv } "> Nom du Magasin</td>
		        </tr>
		        <tr>
		        <td>Colonne montant</td>
		        <td><input type="text" name="colmontant" value=" ${ colmontant } "> Euros</td>
		        </tr>
		        <tr>
		        <td>Colonne yyyytm</td>
		        <td><input type="text" name="colmois" value=" ${ c_yyyytm } "> 201411 to 201443</td>
		        </tr>
		        <tr>
		        <tr>
		        <td>Colonne tiers</td>
		        <td><input type="text" name="coltiers" value=" ${ coltiers } "> URSSAF</td>
		        </tr>
		        <tr>
		        <tr>
		        <td>Colonne Ref1</td>
		        <td><input type="text" name="colref1" value=" ${ colref1 } "> 99S1</td>
		        </tr>
		        <tr>
		        <tr>
		        <td>Colonne Ref2</td>
		        <td><input type="text" name="colref2" value=" ${ colref2 } "> 1234567890123</td>
		        </tr>
		        <tr>
		        <td align="center" ><input type="submit" name="action" value="Sauvegarder"></td>
		        <td align="center" ><input type="submit" name="action" value="Vérifier le fichier Excel"></td>
		        </tr>
		        </table>    
		        <input type="hidden" name="username" value=" +username+ ">
		        <input type="hidden" name="password"  value=" +password+ ">
		        <input type="hidden" name="fini"  value=" +fini+ ">
		        <input type="hidden" name="fxrt"  value=" +fxrt+ ">
		        </form>

		        <table border=1>

		        <tr>
		        <form action="XrtGlobal" method="post">
		        <td>Modifier les parametres GLOBAUX du fichier XRT</td>
		        <td><input type="submit" name="modifier" value="Modifier"></td>
		        </form>
		        </tr>		        
		   
		        <tr>
		        <form action="CodeCompta" method="post">
		        <td>Affecter les codes compatables aux Magasins</td>
		        <td><input type="submit" name="affecter" value="Affecter"></td>
		        </form> 
		        </tr>		        
		        </table>    

</body>
</html>