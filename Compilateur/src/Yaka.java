/* Generated By:JavaCC: Do not edit this line. Yaka.java */
public class Yaka implements YakaConstants {

        static Expression exp = new Expression();
        static Declaration declaration = new Declaration();
        static TabIdent tabIdent = new TabIdent();
        static YVM yvm = new YVM();
        static YVMasm yvmAsm = new YVMasm();

        static int taille = 0;
        static String typeAffect;


        static EtiqUtil ite = new EtiqUtil();
        static EtiqUtil cond = new EtiqUtil();

  public static void main(String args[]) {
    Yaka analyseur;
    java.io.InputStream input;

    if (args.length==1) {
      System.out.print(args[args.length-1] + ": ");
      try {
        input = new java.io.FileInputStream(args[args.length-1]+".yaka");
      } catch (java.io.FileNotFoundException e) {
        System.out.println("Fichier introuvable.");
        return;
      }
    } else if (args.length==0) {
      System.out.println("Lecture sur l'entree standard...");
      input = System.in;
    } else {
      System.out.println("Usage: java Gram [fichier]");
      return;
    }
    try {
      analyseur = new Yaka(input);
      analyseur.analyse();
      System.out.println("analyse syntaxique reussie!");
    } catch (ParseException e) {
      String msg = e.getMessage();
      /*msg = msg.substring(0,msg.indexOf("\n"));*/
      System.out.println("Erreur de syntaxe : "+msg);
    }
  }

/**************************************/
/********debut de la grammaire ********/
/**************************************/
  static final public void analyse() throws ParseException {
    jj_consume_token(PROGRAMME);
    jj_consume_token(ident);
                                yvm.entete(YakaTokenManager.identLu);
                                                        yvmAsm.entete(YakaTokenManager.identLu);
    bloc();
    jj_consume_token(FPROGRAMME);
                  yvm.queue();
                                  yvmAsm.queue();
  }

  static final public void bloc() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONST:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      declConst();
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      declVar();
    }
                                        yvmAsm.ouvrePrinc(taille);
                                        yvm.ouvrePrinc(taille);
    suiteInstr();
  }

  static final public void declConst() throws ParseException {
    jj_consume_token(CONST);
    defConst();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 40:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      jj_consume_token(40);
      defConst();
    }
    jj_consume_token(41);
  }

  static final public void defConst() throws ParseException {
    jj_consume_token(ident);
           declaration.setSaveName(YakaTokenManager.identLu);
    jj_consume_token(42);
    valConst();
  }

  static final public void valConst() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case entier:
      jj_consume_token(entier);
                                if(tabIdent.existeIdent(declaration.getSaveName())){
                                        System.out.println("Erreur : Constante deja\u00c2\u00a0 declaree");
                                }else{
                                        tabIdent.rangeIdent(declaration.getSaveName(), declaration.createIdentConst("ENTIER", YakaTokenManager.entierLu));
                                }
      break;
    case ident:
      jj_consume_token(ident);
                                if(tabIdent.existeIdent(declaration.getSaveName())){
                                                System.out.println("Erreur : Variable deja\u00c2\u00a0 declaree");
                                }else{
                                        if(tabIdent.existeIdent(YakaTokenManager.identLu)){
                                                tabIdent.rangeIdent(declaration.getSaveName(), tabIdent.chercheIdent(YakaTokenManager.identLu));
                                        }else System.out.println("Erreur : Variable non d\u00c3\u00a9clar\u00c3\u00a9e");
                                }
      break;
    case VRAI:
      jj_consume_token(VRAI);
                                if(tabIdent.existeIdent(declaration.getSaveName())){
                                        System.out.println("Erreur : Variable deja\u00c2\u00a0 declaree");
                                }else{
                                        tabIdent.rangeIdent(declaration.getSaveName(), declaration.createIdentConst("BOOLEEN", -1));
                                }
      break;
    case FAUX:
      jj_consume_token(FAUX);
                                if(tabIdent.existeIdent(declaration.getSaveName())){
                                        System.out.println("Erreur : Variable deja\u00c2\u00a0 declaree");
                                }else{
                                        tabIdent.rangeIdent(declaration.getSaveName(), declaration.createIdentConst("BOOLEEN", 0));
                                }
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void declVar() throws ParseException {
    jj_consume_token(VAR);
    type();
    jj_consume_token(ident);
                                        if(tabIdent.existeIdent(YakaTokenManager.identLu)){
                                                System.out.println("Erreur : Variable deja\u00c2\u00a0 declaree");
                                        }else{
                                                tabIdent.rangeIdent(YakaTokenManager.identLu, declaration.createIdentVar(declaration.getSaveName()));
                                                taille += 2;
                                        }
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 40:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_4;
      }
      jj_consume_token(40);
      jj_consume_token(ident);
                                        if(tabIdent.existeIdent(YakaTokenManager.identLu)){
                                                System.out.println("Erreur : Variable deja\u00c2\u00a0 declaree");
                                        }else{
                                                tabIdent.rangeIdent(YakaTokenManager.identLu, declaration.createIdentVar(declaration.getSaveName()));
                                                taille +=2;
                                        }
    }
    jj_consume_token(41);
  }

  static final public void type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ENTIER:
      jj_consume_token(ENTIER);
                 declaration.setSaveName("ENTIER");
      break;
    case BOOLEEN:
      jj_consume_token(BOOLEEN);
                 declaration.setSaveName("BOOLEEN");
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
 * Syntaxe des instructions.
 */
  static final public void suiteInstr() throws ParseException {
    instruction();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 41:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_5;
      }
      jj_consume_token(41);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SI:
      case TANTQUE:
      case ECRIRE:
      case LIRE:
      case ALALIGNE:
      case ident:
        instruction();
        break;
      default:
        jj_la1[7] = jj_gen;
        ;
      }
    }
  }

  static final public void instruction() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ident:
      affectation();
      break;
    case LIRE:
      lecture();
      break;
    case ECRIRE:
    case ALALIGNE:
      ecriture();
      break;
    case TANTQUE:
      iteration();
      break;
    case SI:
      conditionnelle();
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void affectation() throws ParseException {
    jj_consume_token(ident);
                                declaration.setSaveName(YakaTokenManager.identLu);
                                if(tabIdent.existeIdent(declaration.getSaveName())){
                                        typeAffect = tabIdent.chercheIdent(declaration.getSaveName()).getType();
                                }else{
                                        System.out.println("Erreur : Variable non d\u00e9clar\u00e9e");
                                }
    jj_consume_token(42);
    expression();
                                                if(tabIdent.existeIdent(declaration.getSaveName())){
                                                        if(tabIdent.chercheIdent(declaration.getSaveName()) instanceof IdVar){
                                                                if(typeAffect.equals(exp.tipToString(exp.popType()))){
                                                                        yvm.istore(((IdVar)tabIdent.chercheIdent(declaration.getSaveName())).getOffset());
                                                                        yvmAsm.istore(((IdVar)tabIdent.chercheIdent(declaration.getSaveName())).getOffset());
                                                                }else{
                                                                        System.out.println("erreur de type au niveau de l'affectation");
                                                                }
                                                        }else{
                                                                        System.out.println("Erreur : Affectation impossible pour une constante");
                                                        }
                                                }
  }

  static final public void lecture() throws ParseException {
    jj_consume_token(LIRE);
    jj_consume_token(43);
    jj_consume_token(ident);
                                                if(tabIdent.existeIdent(YakaTokenManager.identLu)){
                                                        yvm.lireEnt(((IdVar)tabIdent.chercheIdent(YakaTokenManager.identLu)).getOffset());
                                                        yvmAsm.lireEnt(((IdVar)tabIdent.chercheIdent(YakaTokenManager.identLu)).getOffset());
                                                }else{
                                                        System.out.println("Erreur : Variable non d\u00e9clar\u00e9e");
                                                }
    jj_consume_token(44);
  }

  static final public void ecriture() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ECRIRE:
      jj_consume_token(ECRIRE);
      jj_consume_token(43);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VRAI:
      case FAUX:
      case NON:
      case entier:
      case ident:
      case 43:
      case 51:
        expression();
                                                                yvm.ecrireEnt();
                                                                yvmAsm.ecrireEnt();
        break;
      case chaine:
        jj_consume_token(chaine);
                                                                yvm.ecrireChaine(YakaTokenManager.chaineLue);
                                                                yvmAsm.ecrireChaine(YakaTokenManager.chaineLue);
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(44);
      break;
    case ALALIGNE:
      jj_consume_token(ALALIGNE);
                                                                yvm.aLaLigne();
                                                                yvmAsm.aLaLigne();
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void iteration() throws ParseException {
    jj_consume_token(TANTQUE);
                        ite.push();
                                yvm.faire(ite.peek());
                                yvmAsm.faire(ite.peek());
    expression();
                                        if (!(exp.tipToString(exp.popType()).equals("BOOLEEN"))){
                                                System.out.println("Une expression bool\u00e9enne est attendu");
                                        }else{
                                                yvm.iffaux("FAIT"+ite.peek());
                                                yvmAsm.iffaux("FAIT"+ite.peek());
                                        }
    jj_consume_token(FAIRE);
    suiteInstr();
    jj_consume_token(FAIT);
                        yvm.jump("FAIRE"+ite.peek());
                        yvmAsm.jump("FAIRE"+ite.peek());
                        yvm.fait(ite.peek());
                        yvmAsm.fait(ite.pop());
  }

  static final public void conditionnelle() throws ParseException {
    jj_consume_token(SI);
    expression();
                                                        if (!(exp.tipToString(exp.popType()).equals("BOOLEEN"))){
                                                        System.out.println("Une expression bool\u00e9enne est attendu");
                                                        }

                                                        cond.push();
                                                        yvm.iffaux("SINON"+cond.peek());
                                                        yvmAsm.iffaux("SINON"+cond.peek());
    jj_consume_token(ALORS);
    suiteInstr();
                                                        yvm.jump("FSI"+cond.peek());
                                                        yvmAsm.jump("FSI"+cond.peek());

                                                         yvm.sinon(cond.peek());
                                                        yvmAsm.sinon(cond.peek());
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINON:
      jj_consume_token(SINON);
      suiteInstr();
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    jj_consume_token(FSI);
                        yvm.fsi(cond.peek());
                        yvmAsm.fsi(cond.pop());
  }

/*
 * Expression .
 */
  static final public void expression() throws ParseException {
    simpleExpr();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 42:
    case 45:
    case 46:
    case 47:
    case 48:
    case 49:
      opRel();
      simpleExpr();
                                Expression.Op o = exp.peekOpera();
                                switch(o){
                                        case EGAL :
                                                yvm.iegal();
                                                yvmAsm.iegal();
                                                break;
                                        case DIFF :
                                                yvm.idiff();
                                                yvmAsm.idiff();
                                                break;
                                        case INF :
                                                yvm.iinf();
                                                yvmAsm.iinf();
                                                break;
                                        case INFEGAL :
                                                yvm.iinfegal();
                                                yvmAsm.iinfegal();
                                                break;
                                        case SUP :
                                                yvm.isup();
                                                yvmAsm.isup();
                                                break;
                                        case SUPEGAL :
                                                yvm.isupegal();
                                                yvmAsm.isupegal();
                                                break;
                                        default :
                                }
                                exp.testType2Argv();
      break;
    default:
      jj_la1[12] = jj_gen;
      ;
    }
  }

  static final public void simpleExpr() throws ParseException {
    terme();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OU:
      case 50:
      case 51:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_6;
      }
      opAdd();
      terme();
                        Expression.Op o = exp.peekOpera();
                        switch(o){
                                case PLUS :
                                        yvm.iadd();
                                        yvmAsm.iadd();
                                        break;
                                case MOINS :
                                        yvm.isub();
                                        yvmAsm.isub();
                                        break;
                                case OU :
                                        yvm.ior();
                                        yvmAsm.ior();
                                        break;
                                default :
                        }
                        exp.testType2Argv();
    }
  }

  static final public void terme() throws ParseException {
    facteur();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ET:
      case 52:
      case 53:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_7;
      }
      opMul();
      facteur();
                        Expression.Op o = exp.peekOpera();
                        switch(o){
                                case MUL :
                                        yvm.imul();
                                        yvmAsm.imul();
                                        break;
                                case DIV :
                                        yvm.idiv();
                                        yvmAsm.idiv();
                                        break;
                                case ET :
                                        yvm.iand();
                                        yvmAsm.iand();
                                        break;
                                default :
                        }
                        exp.testType2Argv();
    }
  }

  static final public void facteur() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VRAI:
    case FAUX:
    case entier:
    case ident:
    case 43:
      primaire();
      break;
    case NON:
    case 51:
      opNeg();
      primaire();
                                                Expression.Op o = exp.peekOpera();
                                                switch(o){
                                                        case NON :
                                                                yvm.inot();
                                                                yvmAsm.inot();
                                                                break;
                                                        case MOINS :
                                                                yvm.ineg();
                                                                yvmAsm.ineg();
                                                                break;
                                                        default :
                                                }
                                                exp.testType1Argv();
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void primaire() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VRAI:
    case FAUX:
    case entier:
    case ident:
      valeur();
      break;
    case 43:
      jj_consume_token(43);
      expression();
      jj_consume_token(44);
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void valeur() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case entier:
      jj_consume_token(entier);
                                exp.saveType(Expression.Tip.ENTIER);
                                yvm.iconst(YakaTokenManager.entierLu);
                                yvmAsm.iconst(YakaTokenManager.entierLu);
      break;
    case ident:
      jj_consume_token(ident);
                                if(tabIdent.existeIdent(YakaTokenManager.identLu)){
                                        exp.saveType(exp.stringToTip(tabIdent.chercheIdent(YakaTokenManager.identLu).getType()));
                                        if(tabIdent.chercheIdent(YakaTokenManager.identLu) instanceof IdConst){
                                                yvm.iconst(((IdConst) tabIdent.chercheIdent(YakaTokenManager.identLu)).getValeur());
                                                yvmAsm.iconst(((IdConst) tabIdent.chercheIdent(YakaTokenManager.identLu)).getValeur());
                                        }else{
                                                yvm.iload(((IdVar) tabIdent.chercheIdent(YakaTokenManager.identLu)).getOffset());
                                                yvmAsm.iload(((IdVar) tabIdent.chercheIdent(YakaTokenManager.identLu)).getOffset());
                                        }
                                }else System.out.println("Erreur : Variable non d\u00e9clar\u00e9e");
      break;
    case VRAI:
      jj_consume_token(VRAI);
                                exp.saveType(Expression.Tip.BOOL);
                                yvm.iconst(-1);
                                yvmAsm.iconst(-1);
      break;
    case FAUX:
      jj_consume_token(FAUX);
                                exp.saveType(Expression.Tip.BOOL);
                                yvm.iconst(0);
                                yvmAsm.iconst(0);
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opRel() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 42:
      jj_consume_token(42);
                 exp.saveOp(Expression.Op.EGAL);
      break;
    case 45:
      jj_consume_token(45);
                 exp.saveOp(Expression.Op.DIFF);
      break;
    case 46:
      jj_consume_token(46);
                 exp.saveOp(Expression.Op.INF);
      break;
    case 47:
      jj_consume_token(47);
                 exp.saveOp(Expression.Op.INFEGAL);
      break;
    case 48:
      jj_consume_token(48);
                 exp.saveOp(Expression.Op.SUP);
      break;
    case 49:
      jj_consume_token(49);
                 exp.saveOp(Expression.Op.SUPEGAL);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opAdd() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 50:
      jj_consume_token(50);
          exp.saveOp(Expression.Op.PLUS);
      break;
    case 51:
      jj_consume_token(51);
          exp.saveOp(Expression.Op.MOINS);
      break;
    case OU:
      jj_consume_token(OU);
          exp.saveOp(Expression.Op.OU);
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opMul() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 52:
      jj_consume_token(52);
         exp.saveOp(Expression.Op.MUL);
      break;
    case 53:
      jj_consume_token(53);
         exp.saveOp(Expression.Op.DIV);
      break;
    case ET:
      jj_consume_token(ET);
          exp.saveOp(Expression.Op.ET);
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opNeg() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 51:
      jj_consume_token(51);
                 exp.saveOp(Expression.Op.MOINS);
      break;
    case NON:
      jj_consume_token(NON);
                 exp.saveOp(Expression.Op.NON);
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  static public YakaTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  static public Token token, jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[22];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_0();
      jj_la1_1();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x80000,0x200,0x0,0x120000,0x0,0x8100,0x0,0x42000,0x42000,0x1120000,0x0,0x800,0x0,0x400000,0x800000,0x1120000,0x120000,0x120000,0x0,0x400000,0x800000,0x1000000,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x100,0x50,0x100,0x0,0x200,0x47,0x47,0x808d0,0x5,0x0,0x3e400,0xc0000,0x300000,0x80850,0x850,0x50,0x3e400,0xc0000,0x300000,0x80000,};
   }

  public Yaka(java.io.InputStream stream) {
     this(stream, null);
  }
  public Yaka(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new YakaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  public Yaka(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new YakaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  public Yaka(YakaTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  public void ReInit(YakaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  static final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.Vector jj_expentries = new java.util.Vector();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  static public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[54];
    for (int i = 0; i < 54; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 22; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 54; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  static final public void enable_tracing() {
  }

  static final public void disable_tracing() {
  }

}
