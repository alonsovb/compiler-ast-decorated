package proyecto;

import AST.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author sancho
 */
public class ContextAnalizer2 implements Visitor {
    
    private IdentifierTable it;
    
    public ContextAnalizer2(IdentifierTable table) {
        this.it = table;
    }

    public Object visitAGoal(AGoal aThis, Object arg) {

        if (aThis.mc != null) {
            aThis.mc.visit(this, null);
        }
        //--------------------------------------------------//
        if (aThis.td != null) {
            
            
            aThis.td.visit(this, null);
        }
        //--------------------------------------------------//
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitATypeDecl(ATypeDecl aThis, Object arg) {

        
        if (aThis.td1 != null) {
            
            
            aThis.td1.visit(this, null);
        }
        //--------------------------------------------------//
        if (aThis.td2 != null) {
            
            
            aThis.td2.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAMainClass(AMainClass c, Object arg) {

        
        if (c.id1 != null) {
            
            
        }
        //--------------------------------------------------//
        if (c.id2 != null) {
            
            
        }
        //--------------------------------------------------//
        if (c.ps0 != null) {
            
            
            c.ps0.visit(this, null);
        }


        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitATypeClassDeclaration(ATypeClassDeclaration c, Object arg) {

        
        if (c.cd0 != null) {
            
            
            c.cd0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------    
    public Object visitATypeClassExtendsDeclaration(ATypeClassExtendsDeclaration c, Object arg) {

        
        if (c.ced0 != null) {
            
            c.ced0.visit(this, null);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAClassDeclaration(AClassDeclaration c, Object arg) {

        
        if (c.id1 != null) {
            
            
        }
        //--------------------------------------------------//
        if (c.vd0 != null) {
            
            c.vd0.visit(this, null);
        }
        //--------------------------------------------------//
        if (c.md1 != null) {
            
            c.md1.visit(this, null);
        }

        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAClassExtendsDeclaration(AClassExtendsDeclaration c, Object arg) {

        
        if (c.vd0 != null) {
            
            c.vd0.visit(this, null);
        } else {
            
        }
        if (c.md1 != null) {
            
            c.md1.visit(this, null);
        }
        //--------------------------------------------------//
        if (c.id1 != null) {
            
            
        }
        //--------------------------------------------------//
        if (c.id2 != null) {
            
            
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAVarDeclaration(AVarDeclaration c, Object arg) {

        
        if (c.t0 != null) {
            c.t0.visit(this, null);
        }
        //--------------------------------------------------//
        if (c.id1 != null) {
            
            
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAMethodDeclaration(AMethodDeclaration c, Object arg) {

        
        if (c.t0 != null) {
            c.t0.visit(this, null);
        }
        //--------------------------------------------------//
        if (c.fpb1 != null) {
            c.fpb1.visit(this, null);
        }
        //--------------------------------------------------//
        if (c.vd2 != null) {
            c.vd2.visit(this, null);
        }
        //--------------------------------------------------//
        if (c.sl3 != null) {
            c.sl3.visit(this, null);
        }
        //--------------------------------------------------//
        if (c.e4 != null) {
            c.e4.visit(this, null);
        }
        //--------------------------------------------------//
        if (c.id1 != null) {
            
            
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAFormalParameterList(AFormalParameterList c, Object arg) {

        
        if (c.fpl0 != null) {
            c.fpl0.visit(this, null);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAFormalParameterListRest(AFormalParameterListRest c, Object arg) {

        
        if (c.fpl0 != null) {
            c.fpl0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.fpr1 != null) {
            c.fpr1.visit(this, null);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAFormalParameter(AFormalParameter c, Object arg) {

        
        if (c.t0 != null) {
            c.t0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.id1 != null) {
            
            
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAFormalParameterRest(AFormalParameterRest c, Object arg) {

        
        if (c.fpl0 != null) {
            c.fpl0.visit(this, null);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitATypeSimple(ATypeSimple c, Object arg) {

        
        if (c.st0 != null) {
            c.st0.visit(this, null);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitATypeArray(ATypeArray c, Object arg) {

        
        if (c.at0 != null) {
            c.at0.visit(this, null);
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitATypeIdentifier(ATypeIdentifier c, Object arg) {

        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitACharSimpleType(ACharSimpleType c, Object arg) {

        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitABooleanSimpleType(ABooleanSimpleType c, Object arg) {

        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAnIntegerSimpleType(AnIntegerSimpleType c, Object arg) {

        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnArrayType(AnArrayType c, Object arg) {

        
        if (c.st0 != null) {
            c.st0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementBlock(AStatementBlock c, Object arg) {

        
        if (c.b0 != null) {
            c.b0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementAssignment(AStatementAssignment c, Object arg) {

        
        if (c.as0 != null) {
            c.as0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementArrayAssignment(AStatementArrayAssignment c, Object arg) {

        
        if (c.aas0 != null) {
            c.aas0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementIf(AStatementIf c, Object arg) {

        
        if (c.is0 != null) {
            c.is0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementWhile(AStatementWhile c, Object arg) {

        
        if (c.ws0 != null) {
            c.ws0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementSwitch(AStatementSwitch c, Object arg) {

        if (c.ss0 != null) {
            c.ss0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAStatementPrint(AStatementPrint c, Object arg) {

        if (c.ps0 != null) {
            c.ps0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitABlock(ABlock c, Object arg) {

        if (c.sl0 != null) {
            c.sl0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnAssignmentStatement(AnAssignmentStatement c, Object arg) {

        
        if (c.e0 != null) {
            c.e0.visit(this, null);
        }

//--------------------------------------------------//
        if (c.id1 != null) {
            
            
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnArrayAssignmentStatement(AnArrayAssignmentStatement c, Object arg) {

        
        if (c.e0 != null) {
            c.e0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.e1 != null) {
            c.e1.visit(this, null);
        }
//--------------------------------------------------//
        if (c.id1 != null) {
            
            
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnIfStatement(AnIfStatement c, Object arg) {

        
        if (c.e0 != null) {
            c.e0.visit(this, null);
        }

//--------------------------------------------------//
        if (c.s1 != null) {
            c.s1.visit(this, null);
        }

//--------------------------------------------------//
        if (c.s2 != null) {
            c.s2.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAWhileStatement(AWhileStatement c, Object arg) {

        
        if (c.e0 != null) {
            c.e0.visit(this, null);
        }

//--------------------------------------------------//
        if (c.s1 != null) {
            c.s1.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAPrintStatement(APrintStatement c, Object arg) {

        
        if (c.e0 != null) {
            c.e0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionAnd(AnExpressionAnd c, Object arg) {

        
        if (c.ae0 != null) {
            c.ae0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionPlus(AnExpressionPlus c, Object arg) {

        
        if (c.pe0 != null) {
            c.pe0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionMinus(AnExpressionMinus c, Object arg) {

        
        if (c.me0 != null) {
            c.me0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionTimes(AnExpressionTimes c, Object arg) {

        
        if (c.te0 != null) {
            c.te0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionArrayLookup(AnExpressionArrayLookup c, Object arg) {

        
        if (c.al0 != null) {
            c.al0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionArrayLenght(AnExpressionArrayLenght c, Object arg) {

        
        if (c.al0 != null) {
            c.al0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionMessage(AnExpressionMessage c, Object arg) {

        
        if (c.ms0 != null) {
            c.ms0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnExpressionPrimary(AnExpressionPrimary c, Object arg) {

        
        if (c.pe0 != null) {
            c.pe0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------
    public Object visitAnAndExpression(AnAndExpression c, Object arg) {

        
        if (c.pe0 != null) {
            c.pe0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.pe1 != null) {
            c.pe1.visit(this, null);
        }
        return null;
    }
////////////////////////////////
////////////////////////////////
    //------------------------------------------------------------------------------------------- 
    public Object visitAMenorQueExpression(AMenorQueExpression c, Object arg) {

        
        if ((c.pe0 != null) && (c.pe1 != null)) {
           if( (c.pe0.visit(this, null) == int.class.getName()) &&
                (c.pe1.visit(this, null) == int.class.getName()))
               return Boolean.class.getName();
           else
               dttrrgt;;;;;;;
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAMayorQueExpression(AMayorQueExpression c, Object arg) {

        
        if ((c.pe0 != null) && (c.pe1 != null)) {
           if((c.pe0.visit(this, null) == int.class.getName()) &&
              (c.pe1.visit(this, null) == int.class.getName()))
             return Boolean.class.getName();
           else
               rtgrtg;;;;;;;
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAPlusExpression(APlusExpression c, Object arg) {

        
        if ((c.pe0 != null) && (c.pe1 != null)) {
           if((c.pe0.visit(this, null) == int.class.getName()) &&
              (c.pe1.visit(this, null) == int.class.getName()))
             return Boolean.class.getName();
           else
               rtgrt;;;;;;;
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAMinusExpression(AMinusExpression c, Object arg) {

        
        if ((c.pe0 != null) && (c.pe1 != null)) {
           if((c.pe0.visit(this, null) == int.class.getName()) &&
              (c.pe1.visit(this, null) == int.class.getName()))
             return Boolean.class.getName();
           else
               rtgrt;;;;;;;
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitATimesExpression(ATimesExpression c, Object arg) {

        
        if ((c.pe0 != null) && (c.pe1 != null)) {
           if((c.pe0.visit(this, null) == int.class.getName()) &&
              (c.pe1.visit(this, null) == int.class.getName()))
             return Boolean.class.getName();
           else
               rtgrt;;;;;;;
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitADivExpression(ADivExpression c, Object arg) {

        
        if ((c.pe0 != null) && (c.pe1 != null)) {
           if((c.pe0.visit(this, null) == int.class.getName()) &&
              (c.pe1.visit(this, null) == int.class.getName()))
             return Boolean.class.getName();
           else
               rtgrt;;;;;;;
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAnArrayLookup(AnArrayLookup c, Object arg) {
/// Revisar
        
        if ((c.pe0 != null) && (c.pe1 != null)) {
            
            if(c.pe1.visit(this, null) == int.class.getName())
            return Boolean.class.getName();
            else
            dsfdfdfgd;;;
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAnArrayLength(AnArrayLength c, Object arg) {

        
        if (c.pe0 != null) {
            if(c.pe0.visit(this, null) == int.class.getName())
                return Boolean.class.getName();
            else
                ssdgFDsf;;
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAMessageSend(AMessageSend c, Object arg) {

        
        if (c.pe0 != null) {
            c.pe0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.elb1 != null) {
            c.elb1.visit(this, null);
        }
//--------------------------------------------------//
        if (c.id1 != null) {
            
            
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------  
    public Object visitAnExpressionList(AnExpressionList c, Object arg) {

        
        if (c.e0 != null) {
            c.e0.visit(this, null);
        }
//--------------------------------------------------//        
        if (c.er != null) {
            c.er.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------   
    public Object visitAnExpressionListRest(AnExpressionListRest c, Object arg) {

        
        if (c.el0 != null) {
            c.el0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.er1 != null) {
            c.er1.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------   
    public Object visitAnExpressionRest(AnExpressionRest c, Object arg) {

        
        if (c.e0 != null) {
            c.e0.visit(this, null);
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------   
    public Object visitAPrimaryInteger(APrimaryInteger c, Object arg) {

        
        if (c.int1 != null) {
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------   
    public Object visitAPrimaryChar(APrimaryChar c, Object arg) {

        
        if (c.ch1 != null) {
        }
        return null;
    }

    //------------------------------------------------------------------------------------------- 
    public Object visitAPrimaryString(APrimaryString c, Object arg) {

        
        if (c.str1 != null) {
        }
        return null;
    }

    //-------------------------------------------------------------------------------------------   
    public Object visitAPrimaryTrue(APrimaryTrue c, Object arg) {
        return null;
    }

    //-------------------------------------------------------------------------------------------  
    public Object visitAPrimaryFalse(APrimaryFalse c, Object arg) {
        return null;
    }

    //-------------------------------------------------------------------------------------------  
    public Object visitAPrimaryIdentifier(APrimaryIdentifier c, Object arg) {

        
        if (c.id1 != null) {

        }
        return null;
    }

    //-------------------------------------------------------------------------------------------   
    public Object visitAPrimaryThis(APrimaryThis c, Object arg) {
        return null;
    }

    //-------------------------------------------------------------------------------------------  
    public Object visitAPrimaryAllocationExpression(APrimaryAllocationExpression c, Object arg) {

        
        if (c.ae0 != null) {
            c.ae0.visit(this, null);
        }
        return null;
    }

//-------------------------------------------------------------------------------------------  
    public Object visitAPrimaryNotExpression(APrimaryNotExpression c, Object arg) {

        
        if (c.ne0 != null) {
            c.ne0.visit(this, null);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAConstantInteger(AConstantInteger c, Object arg) {

        
        if (c.int1 != null) {
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAConstantChar(AConstantChar c, Object arg) {

        
        if (c.c1 != null) {
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAConstantString(AConstantString c, Object arg) {

        
        if (c.str1 != null) {
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAConstantTrue(AConstantTrue c, Object arg) {
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAConstantFalse(AConstantFalse c, Object arg) {
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAnArrayAllocationExpression(AnArrayAllocationExpression c, Object arg) {

        
        if (c.e1 != null) {
            c.e1.visit(this, null);
        }
//--------------------------------------------------//
        if (c.st0 != null) {
            c.st0.visit(this, null);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAnAllocationExpression(AnAllocationExpression c, Object arg) {

        
        if (c.id1 != null) {
            
            
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitANotExpression(ANotExpression c, Object arg) {

        
        if (c.e0 != null) {
            c.e0.visit(this, null);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitABracketExpression(ABracketExpression c, Object arg) {

        
        if (c.e0 != null) {
            c.e0.visit(this, null);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAVarDecl(AVarDecl c, Object arg) {

        
        if (c.vd0 != null) {
            c.vd0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.vd1 != null) {
            c.vd1.visit(this, null);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAMethodDecl(AMethodDecl c, Object arg) {

        
        if (c.md0 != null) {
            c.md0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.md1 != null) {
            c.md1.visit(this, null);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAStatementList(AStatementList c, Object arg) {

        
        if (c.sl0 != null) {
            c.sl0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.s1 != null) {
            c.s1.visit(this, null);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAnExpressionListBlock(AnExpressionListBlock c, Object arg) {

        
        if (c.el0 != null) {
            c.el0.visit(this, null);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitASwitchStatement(ASwitchStatement c, Object arg) {

        
        if (c.e0 != null) {
            c.e0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.sb1 != null) {
            c.sb1.visit(this, null);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitACaseBlock(ACaseBlock c, Object arg) {
        
        if (c.ce0 != null) {
            c.ce0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.sl1 != null) {
            c.sl1.visit(this, null);
        }
//--------------------------------------------------//
        if (c.bs2 != null) {
            c.bs2.visit(this, null);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitADefaultBlock(ADefaultBlock c, Object arg) {

        
        if (c.sl0 != null) {
            c.sl0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.bs1 != null) {
            c.bs1.visit(this, null);
        }
        return null;
    }

//-------------------------------------------------------------------------------------------   
    public Object visitACaseBlockList(ACaseBlockList c, Object arg) {

        
        if (c.cbl0 != null) {
            c.cbl0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.cb1 != null) {
            c.cb1.visit(this, null);
        }
        return null;
    }

//-------------------------------------------------------------------------------------------   
    public Object visitASwitchBlock(ASwitchBlock c, Object arg) {

        if (c.cbl0 != null) {
            c.cbl0.visit(this, null);
        }
//--------------------------------------------------//
        if (c.db1 != null) {
            c.db1.visit(this, null);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitABreakStatement(ABreakStatement c, Object arg) {
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAPrimaryArray(APrimaryArray c, Object arg) {

        if (c.aaae0 != null) {
            c.aaae0.visit(this, null);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitASimpleTypeInt(ASimpleTypeInt c, Object arg) {
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitASimpleTypeChar(ASimpleTypeChar c, Object arg) {
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitASimpleTypeBool(ASimpleTypeBool c, Object arg) {
        
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAFormalParameterBlock(AFormalParameterBlock c, Object arg) {

        if (c.fpl0 != null) {
            c.fpl0.visit(this, null);
        }
        return null;
    }

//------------------------------------------------------------------------------------------- 
    public Object visitAnExpressionDiv(AnExpressionDiv c, Object arg) {

        if (c.de0 != null) {
           return c.de0.visit(this, null);
        }
        return null;
    }

//-------------------------------------------------------------------------------------------  
    public Object visitAnExpressionMayor(AnExpressionMayor c, Object arg) {

        if (c.mqe0 != null) {
            return c.mqe0.visit(this, null);
        }
        return null;
    }

//-------------------------------------------------------------------------------------------   
    public Object visitAnExpressionMenor(AnExpressionMenor c, Object arg) {

        if (c.mqe0 != null) {
           return c.mqe0.visit(this, null);
        }
        return null;
    }

//-------------------------------------------------------------------------------------------  
    public Object visitAPrimaryBracket(APrimaryBracket c, Object arg) {
        
        if (c.be0 != null) {
           return c.be0.visit(this, null);
        }
        return null;
   }
//-------------------------------------------------------------------------------------------  
}
