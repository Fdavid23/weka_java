/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicasjesy;


import com.sun.xml.internal.ws.encoding.DataHandlerDataSource;
import java.io.File;
import  weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;

import weka.core.converters.ConverterUtils.DataSource;

import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

/**
 *
 * @author HP
 */
public class PracticasJesy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
       
     
//cargamos la base de datos glass para crear todas las instancias

DataSource file = new DataSource("src/practicasjesy/glass.arff");
 

ConverterUtils.DataSource source = new ConverterUtils.DataSource(file.getDataSet());
Instances instances = source.getDataSet();
instances.setClassIndex(instances.numAttributes() - 1);
 //Imprimimos todas las instancias que existen en la base de datos
 
System.out.println(instances.numInstances() + " instancias cargadas.");
System.out.println(instances.toString());
//borramos algun elemento si esta en el rango de 2 o vacio
      Remove remove = new Remove();
String[] opts = new String[]{"-R", "2"};
remove.setOptions(opts);
remove.setInputFormat(instances);
 //realizamos una comparativa a traves de un arbol de decision para ver que elemneto es mas contaminante entre el arbol de desision
instances = Filter.useFilter(instances, remove);
J48 tree = new J48();
String[] options = new String[1];
options[0] = "-U";
 
tree.setOptions(options);
 
tree.buildClassifier(instances);
 
System.out.println(tree);
    }
    
}
