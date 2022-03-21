package Model;

import java.util.ArrayList;

public class Polinom<E> extends ArrayList<E> {

   public Polinom<Monom> adunare(Polinom<Monom> polinom1, Polinom<Monom> polinom2){
       double c,p;
       int i;
       Polinom<Monom> polinom3 = new Polinom<Monom>();
       if(polinom1.size() >= polinom2.size()){

          for(Monom monom1 : polinom1){
              for(Monom monom2 : polinom2){
                  if(monom1.getPutere() == monom2.getPutere())
                  {
                      c = (monom1.getCoeficient() + monom2.getCoeficient());
                      p = monom1.getPutere();
                      polinom3.add( new Monom(c,p) );
                  }
              }
          }

           for(i=polinom2.size();i < polinom1.size();i++){
               c = ((Monom) polinom1.get(i)).getCoeficient();
               p = ((Monom) polinom1.get(i)).getPutere();
               polinom3.add( new Monom(c,p) );
           }
       }
       else{
           for(Monom monom2 : polinom2){
               for(Monom monom1 : polinom1){
                   if(monom1.getPutere() == monom2.getPutere())
                   {
                       c = (monom1.getCoeficient() + monom2.getCoeficient());
                       p = monom2.getPutere();
                       polinom3.add( new Monom(c,p) );
                   }
               }
           }
           for(i=polinom1.size();i < polinom2.size();i++){
               c = ((Monom) polinom2.get(i)).getCoeficient();
               p = ((Monom) polinom2.get(i)).getPutere();
               polinom3.add( new Monom(c,p) );
           }
       }
       return polinom3;
   }
    public Polinom<Monom> scadere(Polinom<Monom> polinom1,Polinom<Monom> polinom2){
        double c,p;
        int i;
        Polinom<Monom> polinom3 = new Polinom<Monom>();
        if(polinom1.size() >= polinom2.size()){

            for(Monom monom1 : polinom1){
                for(Monom monom2 : polinom2){
                    if(monom1.getPutere() == monom2.getPutere())
                    {
                        c = (monom1.getCoeficient() - monom2.getCoeficient());
                        p = monom1.getPutere();
                        polinom3.add( new Monom(c,p) );
                    }
                }
            }

            for(i=polinom2.size();i < polinom1.size();i++){
                c = ((Monom) polinom1.get(i)).getCoeficient();
                p = ((Monom) polinom1.get(i)).getPutere();
                polinom3.add( new Monom(c,p) );
            }
        }
        else{
            for(Monom monom2 : polinom2){
                for(Monom monom1 : polinom1){
                    if(monom1.getPutere() == monom2.getPutere())
                    {
                        c =(monom1.getCoeficient() - monom2.getCoeficient());
                        p = monom2.getPutere();
                        polinom3.add( new Monom(c,p) );
                    }
                }
            }
            for(i=polinom1.size();i < polinom2.size();i++){
                c = (-1)*((Monom) polinom2.get(i)).getCoeficient();
                p = ((Monom) polinom2.get(i)).getPutere();
                polinom3.add( new Monom(c,p) );
            }
        }

        return polinom3;
    }

    public Polinom<Monom> inmultire (Polinom<Monom> polinom1, Polinom<Monom> polinom2){
        double c=0,p,c1;
        int i,j,l=0,ok=0,p1;
        double[] a=new double[100];
        Polinom<Monom> polinom3 = new Polinom<Monom>();
        Polinom<Monom> polinom4 = new Polinom<Monom>();
        Polinom<Monom> polinom5 = new Polinom<Monom>();


        for(i=0;i<=(polinom1.size()+polinom2.size());i++){
            p=(double)i;
            polinom3.add(new Monom(0,p));
            polinom4.add(new Monom(0,p));
            a[i]=0;
        }
        for(i=0;i<polinom1.size();i++){
            for(j=0;j<polinom2.size();j++){
                p=polinom1.get(i).getPutere()+polinom2.get(j).getPutere();
                c=polinom1.get(i).getCoeficient()*polinom2.get(j).getCoeficient();
                p1=(int)p;
                a[p1]=a[p1]+c;
                //polinom3.add(new Monom(c,p));
            }
        }
        for(i=0;i<=(polinom1.size()+polinom2.size());i++){
            if(a[i]!=0){
                p=(double)i;
            polinom3.add(new Monom(a[i],i));}
        }

        return polinom3;
    }

    public Polinom<Monom> impartire (Polinom<Monom> polinom1){
        double c,p;
        Polinom<Monom> polinom3 = new Polinom<Monom>();


        return polinom3;
    }

    public Polinom<Monom> derivare (Polinom<Monom> polinom1){
        double c,p;
        Polinom<Monom> polinom3 = new Polinom<Monom>();

        for(Monom monom1 : polinom1){
                c = monom1.getCoeficient()*monom1.getPutere();
                p = monom1.getPutere()-1;
                if(p>= 0){
                polinom3.add(new Monom(c,p));
                }
        }
        return polinom3;
    }

    public Polinom<Monom> integrare (Polinom<Monom> polinom1){
        double c,p;
        int i;
        Polinom<Monom> polinom3 = new Polinom<Monom>();

        for(i=0;i<polinom1.size();i++){
            c=polinom1.get(i).getCoeficient()/(polinom1.get(i).getPutere()+1);
            p=polinom1.get(i).getPutere()+1;
            polinom3.add(new Monom(c,p));
        }
        return polinom3;
    }

    public String afisare(Polinom<Monom> rezultat){
        StringBuffer polinom = new StringBuffer();
        double c,p;
        for(Monom monom1: rezultat){
            p = monom1.getPutere();
            c = monom1.getCoeficient();
            if(  c != 0 ){
                if( p > 0 ) {
                    if(c==(int)c)
                    polinom.append((int)c + "x^" + (int) p + " + ");
                    else
                        polinom.append(c + "x^" + (int) p + " + ");
                }
                else if ( p == 0 ){
                    if(c==(int)c)
                    polinom.append((int)c + " + ");
                    else
                        polinom.append(c + " + ");

                }
            }
        }
        if(polinom.length()>0)
            polinom.delete( polinom.length() - 2, polinom.length() );
        else
            polinom.append("0");
        return polinom.toString();
    }

}