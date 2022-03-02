/**
* Script que crea un archivo csv con texto en
* mayuscula a partir de otro archivo csv
*
* args[0] - String. Corresponde a la ruta al
* archivo csv que se desea pasar a mayuscula
*
* args[1] - String. Opcional por diseno. ruta
* y nombre del archivo generado.
*/

String path = args[0]
File f = new File(path)
def line, filename, noOfLines = 0

try {
    filename = args[1]
} catch(ArrayIndexOutOfBoundsException e1) {
    filename = "uppercase_out.csv"
}

def csvOut = new File(filename)
csvOut.createNewFile()

f.withReader { reader ->
    while ((line = reader.readLine()) != null){
        csvOut << "${line.toUpperCase()}\n"
        noOfLines++
        if (noOfLines == 7) {
            break
        }
    }
} 