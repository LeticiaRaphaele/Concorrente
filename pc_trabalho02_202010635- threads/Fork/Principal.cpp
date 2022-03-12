/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Autor....: Leticia Raphaele Silva
Matrícula: 202010635
Inicio...: 09/03/2022
Alteracao: 11/03/2022
Nome.....: Principal.cpp
Funcao...: Arvore genealogica utilizando comando Fork em C++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

#include <iostream>
#include <time.h>
#include <unistd.h>// Biblioteca especifica da linux

using namespace std;

int main(void){
	pid_t idProcesso;// identificacao do projeto
	
	cout << "Inicio da simulacao"<< "\n";
	idProcesso = fork();// criando o processo
	
    if(idProcesso == -1){// ocorreu um erro na chamada do processo
        exit(1);
    }//fim do if do erro

    if(idProcesso == 0){
        sleep(22);
        cout << "Nasceu o primeiro filho que possui como ID: " << getppid() << ", e o seu pai tem id: " << getpid() << "\n";
        idProcesso = fork();// crio um novo processo que sera referente ao filho do PFilho, ou sejo o neto 1

        if(idProcesso == -1){
            exit(1);
        }//fim do if do erro do neto 1
        
        
        // referente ao neto 1
        if(idProcesso == 0){
            sleep(16); // como o parent desse processo ja dormiu por 22 segundos: 22+16 = 38
            cout << "Nasceu o primeiro neto que possui como ID: " << getppid() << ", e tem como id de seu pai: " << getpid()<< "\n";
            idProcesso = fork();
            
            //tempo de duracao 38s

            if(idProcesso == -1){
                exit(1);
            }//fim do if erro do bisneto

            if(idProcesso == 0){// processo referente ao bisneto
                sleep(30);
                cout <<"Nasceu o bisneto que possui como ID: " << getppid() << ", e tem como id de seu pai: " << getpid()<< "\n";

                // tempo de duracao 68s

                sleep(12);// o bisneto envelhece 12 anos
                cout << "Morreu o bisneto, que possui como id: " << getppid() <<", e tem como id do pai: " << getpid()<< "\n";
                _exit(0);
                
                //tempo ate aqui 80s

            }//fim do if (processo do bisneto)

            else{// segue o processo do neto 1
                sleep(35);
                cout << "Morreu o primeiro neto, que possui como id: " << getppid() <<", e tem como id do pai: " << getpid() << "\n";
                
                sleep(10);
                //geramos esse sleep para que o processo do bisneto tenha tempo de finalizar seu processo, pois se nap 
                //o gidppid retornara 1 para ele, ja que o processo teria sido finalizado antes de seu tempo

                 _exit(0);
            }//fim do if (processo do neto 1)

        }//fim do if(processo do neto 1)
        
        
        //referente ao processo do filho 1
        else{
            sleep(61);
            cout << "Morreu o primero filho, que possui como id: " << getppid() <<", e tem como id do pai: " << getpid() << "\n";
            _exit(0);

        }// fim do else para o processo do filho 1.
    }//fim do if (processo do 1 filho)
    
    
    //processo pai
    else{
        cout << "Nasceu o pai com ID: " << getpid() << "\n";
        sleep(25);// pai tem filho dois com 25 anos
        idProcesso = fork();
        
        //tempo de que se passou 25s
        
        if(idProcesso == -1){
            exit(1);
        }//fim do erro filho 2

        if(idProcesso == 0){
            cout << "Nasce o segundo filho, id pai = " << getppid() << " id filho = " << getpid() << "\n";
            sleep(20);
            idProcesso = fork();
            
            //tempo de que se passou 45s

            if(idProcesso == -1){
                exit(1);
            }//fim do erro neto 2

            // inicio do processo referente ao neto 2
            if(idProcesso == 0){ 
                cout <<"Nasceu o segundo neto  que possui como ID: " << getppid() << ", e tem como id de seu pai: " << getpid() << "\n";
                sleep(33); 
                cout << "Morreu o segundo neto, que possui como id: " << getppid() <<", e tem como id do pai: " << getpid() << "\n";
                _exit(0);
                
                //tempo de que se passou 78s
                
            }//fim do if (processo do neto 2) 
            
            //processo do segundo filho
            else{
                sleep(30);
                cout << "Morreu o segundo filho, que possui como id: " << getppid() <<", e tem como id do pai: " << getpid() << "\n";
                _exit(0);
                
            }//fim do else filho 2
        }// fim do if do filho 2

        else{// continuacao do processo pai
            sleep(7);
            idProcesso = fork();
            
            //tempo que se passou no pai foi de 32s
            if(idProcesso == -1){
                exit(1);
            }// fim do erro filho 3
            
            
            //processo do filho 3
            if(idProcesso == 0){
                
                cout << "Nasceu o terceiro filho  que possui como ID: " << getppid() << ", e tem como id de seu pai: " << getpid()<< "\n";
                sleep(55); 
                cout << "Morreu o terceiro filho, que possui como id: " << getppid() <<", e tem como id do pai: " << getpid()<< "\n";
                _exit(0);
            }//fim do if filho 3
            
            else{
                sleep(58);
                cout << "Morre o pai, que possui id = " << getpid() << "\n";
                
                //tempo que se passou no pai 90s

            }//fim do else processo pai;
        }//fim do if (processo pai)
    }//fim do else (pai)

    return 0;
}//fim do main
