package org.omg.DynamicAny;


/**
* org/omg/DynamicAny/DynSequenceOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/jenkins/workspace/8-2-build-windows-x64-cygwin/jdk8u341/2692/corba/src/share/classes/org/omg/DynamicAny/DynamicAny.idl
* Thursday, June 16, 2022 3:52:36 PM UTC
*/


/**
    * DynSequence objects support the manipulation of IDL sequences.
    */
public interface DynSequenceOperations  extends org.omg.DynamicAny.DynAnyOperations
{

  /**
        * Returns the current length of the sequence.
        */
  int get_length ();

  /**
        * Sets the length of the sequence.
        * Increasing the length of a sequence adds new elements at the tail without affecting the values
        * of already existing elements. Newly added elements are default-initialized.
        * Increasing the length of a sequence sets the current position to the first newly-added element
        * if the previous current position was -1. Otherwise, if the previous current position was not -1,
        * the current position is not affected.
        * Decreasing the length of a sequence removes elements from the tail without affecting the value
        * of those elements that remain. The new current position after decreasing the length of a sequence
        * is determined as follows:
        * <UL>
        * <LI>If the length of the sequence is set to zero, the current position is set to -1.
        * <LI>If the current position is -1 before decreasing the length, it remains at -1.
        * <LI>If the current position indicates a valid element and that element is not removed when the length
        *     is decreased, the current position remains unaffected.
        * <LI>If the current position indicates a valid element and that element is removed,
        *     the current position is set to -1.
        * </UL>
        *
        * @exception InvalidValue if this is a bounded sequence and len is larger than the bound
        */
  void set_length (int len) throws org.omg.DynamicAny.DynAnyPackage.InvalidValue;

  /**
        * Returns the elements of the sequence.
        */
  org.omg.CORBA.Any[] get_elements ();

  /**
        * Sets the elements of a sequence.
        * The length of the DynSequence is set to the length of value. The current position is set to zero
        * if value has non-zero length and to -1 if value is a zero-length sequence.
        *
        * @exception TypeMismatch if value contains one or more elements whose TypeCode is not equivalent
        *            to the element TypeCode of the DynSequence
        * @exception InvalidValue if the length of value exceeds the bound of a bounded sequence
        */
  void set_elements (org.omg.CORBA.Any[] value) throws org.omg.DynamicAny.DynAnyPackage.TypeMismatch, org.omg.DynamicAny.DynAnyPackage.InvalidValue;

  /**
        * Returns the DynAnys representing the elements of the sequence.
        */
  org.omg.DynamicAny.DynAny[] get_elements_as_dyn_any ();

  /**
        * Sets the elements of a sequence using DynAnys.
        * The length of the DynSequence is set to the length of value. The current position is set to zero
        * if value has non-zero length and to -1 if value is a zero-length sequence.
        *
        * @exception TypeMismatch if value contains one or more elements whose TypeCode is not equivalent
        *            to the element TypeCode of the DynSequence
        * @exception InvalidValue if the length of value exceeds the bound of a bounded sequence
        */
  void set_elements_as_dyn_any (org.omg.DynamicAny.DynAny[] value) throws org.omg.DynamicAny.DynAnyPackage.TypeMismatch, org.omg.DynamicAny.DynAnyPackage.InvalidValue;
} // interface DynSequenceOperations
