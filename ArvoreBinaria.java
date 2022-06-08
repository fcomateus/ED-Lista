/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvorebinariagenerica;

/**
 *
 * @author fmfr
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;



public class ArvoreBinaria {
	No root; // No raiz 
        
        ArrayList<Object> repetidos = new ArrayList<>();
        ArrayList<No> elementos = new ArrayList<>();

	public No Create(Object x, No e, No  d) {
	 		 No Aux = new No(x);
			 Aux.esq = e;
	  		 Aux.dir = d;

	  		 return Aux;
	     }

	/*--------------- PERCURSOS -------------------- */

	public ArvoreBinaria() {
	   root = null;
	}

	public void Criar_Raiz(Object x)
	{
	   root = new No(x);
	}

	public boolean isEmpty()
	{
	  return root == null;
	}

	/*---------------------------------------------------------------*/
	public boolean verificarFolhaVogal(No N) {
		boolean retorno = false;
		if (N != null) {
			      if(N.esq == null && N.dir == null) {
			    	  if (N.Dado.equals("A") || N.Dado.equals("E") || N.Dado.equals("I")
			    			  || N.Dado.equals("O") || N.Dado.equals("U")) {
			    		  retorno = true;
			    	  }
			      }
			      retorno = retorno || verificarFolhaVogal(N.esq);
			      retorno = retorno || verificarFolhaVogal(N.dir);
		   }
		return retorno;
	}
	//------------------------------------------------------------------------------------
	
	public boolean numeroFolhasMaiorInternos(No n) {
		int contFolhas = contarFolhas(n);
		int contInterno = contarInternos(n);
		return contFolhas > contInterno;
	}
	
	public void InOrdem(No N) {
		   if (N != null) {
		      InOrdem(N.esq);
		      System.out.print(N.Dado + "   ");
		      InOrdem(N.dir);
		   }

		}
	public void PreOrdem(No N) {
	   if (N != null) {
	      System.out.print(N.Dado + "   ");
		    PreOrdem(N.esq); //1
	      PreOrdem(N.dir); //2
	   }

	}
  	public void PosOrdem(No N) {

	   if (N != null) {
	    
	      PosOrdem(N.esq);
	      PosOrdem(N.dir);
	      System.out.print(N.Dado + "   ");
	   }

	}
	
//----------------------------------
	
	
	public void largura(No N) {
		Queue<No> fila = new LinkedList<No>();
		No aux = null;
		fila.add(N);
		while (!fila.isEmpty()) {
			System.out.println(fila.peek().Dado);
			aux = fila.poll();
			if(aux.esq != null) fila.add(aux.esq);
			if(aux.dir != null) fila.add(aux.dir);
		}
	}

	public void Euler(No N) {

	   if (N != null) {
	      System.out.print(N.Dado + "   ");//1
	      Euler(N.esq);
	      System.out.print(N.Dado + "   ");//2
	      Euler(N.dir);
	      System.out.print(N.Dado + "   ");//3
	   }

	}
	
	
	public static boolean verificarFolhasInterno(No raiz) {
		return (contarFolhas(raiz) > contarInternos(raiz));
	}
	
	// Contar o numero de nos internos da arvore binaria
	public static int contarInternos(No n) {
		int cont = 0;
		if (n != null) {
			cont += contarInternos(n.esq);
			cont += contarInternos(n.dir);
			if (n.esq != null || n.dir != null) cont++;
		}
		return cont;
	}
	
	////
	static int contPre=0;
	private void PreOrdemCont(No N) {
		   if (N != null) {
			 //if (N.esq == null && N.dir == null) 
				contPre++;
			  PreOrdemCont(N.esq); //1
		    PreOrdemCont(N.dir); //2
		   }
		}
	////
	public int ContarbyGambi(No N) {
		contPre=0;
		PreOrdemCont(N);
		return contPre;
				
	}

	// Contar o numero de nos Folhas da arvore binaria
	public static int contarFolhas(No n) {
		int cont = 0;
		if (n != null) {
			cont += contarFolhas(n.esq);
			cont += contarFolhas(n.dir);
			if (n.esq == null && n.dir == null) cont++;
		}
		return cont;
	}

        No irmaoRetorno;
	
	// irmao de um determinado no em uma árvore binária
	public No irmao(No raiz, final No noIrmao) {
		No irmao = null;
		if (raiz != null) {
                    System.out.println("No atual: "+ raiz.Dado);
			if (raiz.esq != null && raiz.esq.Dado.equals(noIrmao.Dado))  {
                            System.out.println("Comparando com filho da esquerda");
                                                        
                            irmao = raiz.dir;
                            irmaoRetorno = irmao;
                            System.out.println("No irmao de "+noIrmao.Dado+": "+ irmao.Dado);
                            
                            return irmaoRetorno;
                        }
			if (raiz.dir != null && raiz.dir.Dado.equals(noIrmao.Dado)){
                            System.out.println("Comparando com filho da direita");

                            irmao = raiz.esq;
                            irmaoRetorno = irmao;
                            System.out.println("No irmao de "+noIrmao.Dado+": "+ irmao.Dado);
                            
                            return irmaoRetorno;
                        }
			
			if (irmao == null) {
				irmao = irmao(raiz.esq, noIrmao);
				irmao = irmao(raiz.dir, noIrmao);
			}
		}
		return irmaoRetorno;
	}
        
        public No buscar(Object busca){
            retornoBusca = null;
            PreOrdemBusca(this.root, busca);
            
            if(retornoBusca != null){
                return retornoBusca;
            } else {
                return null;
            }
            
        }
        
        No retornoBusca;
        
        private void PreOrdemBusca(No N, Object busca) {
	   if (N != null) {
               if(N.Dado.equals(busca)){
                   retornoBusca = N;
               }
               
                PreOrdemBusca(N.esq, busca); //1
                PreOrdemBusca(N.dir, busca); //2
	   }
	}
	
	// Contar o numero de nos da arvore binaria
	public int contar(No n) {
		int cont = 0;
		if (n != null) {
			cont = cont + contar(n.esq); //1
			cont = cont + contar(n.dir); //2
			cont++;
		}
		return cont;
	}
  //Reimplementar o cóódigo acima de contar o núúmero de nóós da árvore para contar apenas os nós folhas ou seja nãão tem Filho_Esquerdo

  //Verificar se existe elementos repetidos na árvore binária. Retornar true ou false;

	static int i=0;
	public No Constroi(No T, String s) {

	 char dado = s.charAt(i++);
	 if (dado != '.') {
	          T = new No(new Character(dado));
	          T.esq = Constroi(T.esq, s);
	          T.dir = Constroi(T.dir, s);
	     } else T = null;
	     
	  return T;   
	}

	public int altura() {
		return altura(this.root, 0);
	}
	private int altura(No n, int a) {

	        int alturae = 0, alturad = 0;
	        
	        if (n != null) {
	            alturae = alturad = a;
	            alturae = Math.max(alturae, altura(n.esq, a + 1));
	            alturad = Math.max(alturad, altura(n.dir, a + 1));
	            System.out.println("Fator de Balanceamento: " + n.Dado + "  " + (alturae-alturad));
	        }
	        return ((alturae > alturad) ? alturae : alturad) ;
	}

	/*----------------------------------------------------------------*/

	public void Criar_Filho_Esquerdo(No pai, Object x) {
	   if (pai != null) {
	     if (pai.esq != null) System.out.println("Subárvore já existente "); 
	     else  pai.esq = new No(x);
	       
	   }
	}

	public void Criar_Filho_Direito(No pai, Object x) {
	   if (pai != null) {
	     if (pai.dir != null) System.out.println("Subárvore já existente ");
	     else  pai.dir = new No(x);
	       
	   }
	}

	public No Filho_Direito(No pai) {
		return pai.dir;
	}

	public No Filho_Esquerdo(No pai) {
		return pai.esq;
	}

        //Clone o root para ter uma cópia da arvore
	public static No copia(No T1, No T2) {
	    if (T1 != null) {
	       //System.out.println(T1.Dado + "\n");
	       T2 = new No(T1.Dado);
	       T2.esq = copia(T1.esq, T2.esq); //1
	       T2.dir = copia(T1.dir, T2.dir); //2
	    }
	    return T2;
	}

	void Descendentes(No N, Object el, boolean cond) {
	   
	    if (N != null) {
	    
	      if (cond) System.out.print(N.Dado + "   ");  
	      
	      if (N.Dado.equals(el)) cond = true; 
	      
	      
	      Descendentes(N.esq, el, cond);
	      Descendentes(N.dir, el, cond);
	   }
            

	}
        
        public boolean temRepetidos(){
            repetidos.clear();
            PreOrdemRepetidos(root);
            //System.out.println(repetidos);
            boolean r = false;
            
            for(int i = 0; i < repetidos.size(); i++){
                for(int j = i+1; j < repetidos.size(); j++){
                    if(repetidos.get(i).equals(repetidos.get(j))){
                        r = true;
                        return r;
                    }
                }
            
            
            }
            return r;
        }
        
        private void PreOrdemRepetidos(No N){
           if (N != null) {
	      //System.out.print(N.Dado + "   ");
              repetidos.add(N.Dado);
              PreOrdemRepetidos(N.esq); //1
	      PreOrdemRepetidos(N.dir); //2
	   } 
        }
        
        public No clonar(No raiz){
            if(raiz == null) return null;
            
            No copia_root = new No(raiz.Dado);
//            copia_root.esq = clonar(raiz.esq);
//            copia_root.dir = clonar(raiz.dir);

            copia_root.esq = raiz.esq;
            copia_root.dir = raiz.dir;
            
            return copia_root;
        }
        
        public No espelhar(No raiz){
            if(raiz == null){
                return null;
            }
                    
            No espelho = new No (raiz.Dado);
            espelho.dir = espelhar(raiz.esq);
            espelho.esq = espelhar(raiz.dir);
            
            return espelho;
        }
        
        public No predecessor(Object dado){
            elementos.clear();
            No predecessor = new No();
            
            caminhar(this.root);
            //System.out.println(elementos);
            Object[] dadosNos = new Object [elementos.size()];
            
            
            System.out.println("Antes do sort");
            for(int i = 0; i < dadosNos.length; i++){
                dadosNos[i] = elementos.get(i).Dado;
                
                System.out.print(dadosNos[i] + " ");
            }
            
            System.out.println("");
            
            System.out.println("Depois do sort");
            Arrays.sort(dadosNos);
            
            boolean existe = false;
            for(int i = 0; i < dadosNos.length; i++){
                if(dadosNos[i].equals(dado)){
                    existe = true;
                }
                System.out.print(dadosNos[i] + " ");
            }
            
            if(!existe){
                System.out.println("Nó "+dado+" não existe na árvore");
                predecessor.Dado = "Nó "+dado+" não existe na árvore";
                return predecessor;
            }
            
            for(int i = 0; i < dadosNos.length; i++){
                System.out.println("Comparando " +dado+" com "+ dadosNos[i]);
                //System.out.println(dadosNos[i].getClass());
                if(dadosNos[i].equals(dado) && i == 0){
                    predecessor.Dado = "Esse nó não tem predecessor";
                } else if(dadosNos[i].equals(dado)){
                    System.out.println("Achei o No!");
                    for(int j = 0; j < elementos.size(); j++){
                        if(elementos.get(j).Dado.equals(dadosNos[i-1])){
                            predecessor = elementos.get(j);
                            return predecessor;
                        }
                    }
                }
            }

            return predecessor;
        }
        
        public No sucessor(Object dado){
            elementos.clear();
            No sucessor = new No();
            
            caminhar(this.root);
            //System.out.println(elementos);
            Object[] dadosNos = new Object [elementos.size()];
            
            System.out.println("Antes do sort");
            for(int i = 0; i < dadosNos.length; i++){
                dadosNos[i] = elementos.get(i).Dado;
                
                System.out.print(dadosNos[i] + " ");
            }
            
            System.out.println("");
            
            System.out.println("Depois do sort");
            Arrays.sort(dadosNos);
            
            boolean existe = false;
            for(int i = 0; i < dadosNos.length; i++){
                if(dadosNos[i].equals(dado)){
                    existe = true;
                }
                System.out.print(dadosNos[i] + " ");
            }
            
            if(!existe){
                System.out.println("Nó "+dado+" não existe na árvore");
                sucessor.Dado = "Nó "+dado+" não existe na árvore";
                return sucessor;
            }
            
            for(int i = 0; i < dadosNos.length; i++){
                System.out.println("Comparando " +dado+" com "+ dadosNos[i]);
                //System.out.println(dadosNos[i].getClass());
                if(dadosNos[i].equals(dado) && i == dadosNos.length - 1){
                    sucessor.Dado = "Esse nó não tem sucessor";
                } else if(dadosNos[i].equals(dado)){
                    System.out.println("Achei o No!");
                    for(int j = 0; j < elementos.size(); j++){
                        if(elementos.get(j).Dado.equals(dadosNos[i+1])){
                            sucessor = elementos.get(j);
                            return sucessor;
                        }
                    }
                }
            }
            

            return sucessor;
        }
        
        private void caminhar(No N){
           if (N != null) {
	      //System.out.print(N.Dado + "   ");
              elementos.add(N);
              caminhar(N.esq); //1
	      caminhar(N.dir); //2
	   } 
        }
        
        private void caminharRemover(No N, Object data){
            if (N != null) {
	      //System.out.print(N.Dado + "   ");
              //elementos.add(N);
              
              //sou o root
              if(root.Dado.equals(data)){
                  remover = N.Dado;
                  root = null;
                  
                  return;
              } else if(N.esq != null && N.esq.Dado.equals(data)){
                 remover = N.esq.Dado;
                 N.esq = null;
                 return;
              } else if(N.dir != null && N.dir.Dado.equals(data)){
                 remover = N.dir.Dado;
                 N.dir = null;
                 return;
              }
              
//              if(data.equals(N.Dado)){
//                  remover = copia(N, remover);
//                  N = null;
//                  return;
//              }
              caminharRemover(N.esq, data); //1
	      caminharRemover(N.dir, data); //2
	   } 
        }
        
//        private void caminharDeletarNo(No N){
//            if (N != null) {
//	      //System.out.print(N.Dado + "   ");
//              //elementos.add(N);
//              if(remover.equals(N.esq.Dado)){
//                  N.esq = null;
//              } else if(remover.equals(N.dir.Dado)) {
//                  N.dir = null;
//              } else if(remover.equals(N.Dado)){
//                  N.Dado = null;
//                  N.dir = null;
//                  N.esq = null;
//              }
//              caminharDeletarNo(N.esq); //1
//	      caminharDeletarNo(N.dir); //2
//	   } 
//        }
        
        Object remover;
        
        public Object removerSubArvore(Object removido){
            //elementos.clear();
            remover = null;
            //remover = removido;
            caminharRemover(this.root, removido);
            
            Object noRemovido = remover;
            
            
//            boolean existe = false;
//            for(int i = 0; i < elementos.size(); i++){
//                if(elementos.get(i).Dado.equals(removido)){
//                    System.out.println("elemento "+removido+" existe!");
//                    
//                    System.out.println(elementos.get(i).Dado);
//                    System.out.println(elementos.get(i).esq);
//                    System.out.println(elementos.get(i).dir);
//                    
//                    existe = true;
//                    
//                    noRemovido.Dado = elementos.get(i).Dado;
//                    noRemovido.esq = new No(elementos.get(i).esq);
//                    noRemovido.dir = new No(elementos.get(i).dir);
//                    
//                    remover = noRemovido.Dado;
//                    caminharDeletarNo(noRemovido);
//                }
//                //System.out.print(elementos.get(i).Dado + " ");
//            }
//            
//            if(!existe){
//                System.out.println("Nó "+removido+" não existe na árvore");
//            }
            
            return noRemovido;
        }
        
        private void deletarMaisProfundo(No raiz, No delecao){
            Queue<No> q = new LinkedList<>();
            q.add(raiz);
            
            No temp = null;
            
            while(!q.isEmpty()){
                temp = q.peek();
                q.remove();
                
                if(temp == delecao){
                    temp = null;
                    return;
                }
                
                if(temp.dir != null){
                    if(temp.dir == delecao){
                        temp.dir = null;
                        return;
                    } else {
                        q.add(temp.dir);
                    }
                }
                
                if(temp.esq != null){
                    if(temp.esq == delecao){
                        temp.esq = null;
                        return;
                    } else {
                        q.add(temp.esq);
                    }
                }
                
                
                
            }
        }
        
        public void deletarNo(No raiz, Object dado){
            
            if(raiz == null){
                return;
            }
            
            if(raiz.esq == null && raiz.dir == null){
                if(raiz.Dado == dado){
                    raiz = null;
                    return;
                } else {
                    return;
                }
            
            }
            
            Queue<No> q = new LinkedList<>();
            q.add(raiz);
            
            No temp = null, dadoNo = null;
            
            while(!q.isEmpty()){
                temp = q.peek();
                q.remove();
                
                if(temp.Dado == dado){
                    dadoNo = temp;
                }
                
                if(temp.esq != null){
                    q.add(temp.esq);
                }
                
                if(temp.dir != null){
                    q.add(temp.dir);
                }
            }
            
            if(dadoNo != null){
                Object x = temp.Dado;
                deletarMaisProfundo(raiz, temp);
                dadoNo.Dado = x;
            }
  
        }
}
