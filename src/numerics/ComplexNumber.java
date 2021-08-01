/*
 * Copyright (C) 2021 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package numerics;

import arithmetic.Arithmeticable;

/**
 * Represents a complex number. A complex number has a real part and an
 * imaginary part. In this class, both parts are represented as floating point
 * numbers.
 * @author Alonso del Arte
 */
public class ComplexNumber implements Arithmeticable<ComplexNumber>  {

    private final double realPart, imagPart;

    // TODO: Write test for this
    @Override
    public String toString() {
        return this.realPart + " + " + this.imagPart + "i";
    }

    // TODO: Write test for this
    public String toASCIIString() {
        return "Sorry, not implemented yet";
    }

    public double getRealPart() {
        return this.realPart;
    }

    public double getImagPart() {
        return this.imagPart;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if (this.realPart != other.realPart) {
            return false;
        }
        return this.imagPart == other.imagPart;
    }

    // TODO: Write test for this
    @Override
    public int hashCode() {
        return Integer.MIN_VALUE;
    }

    @Override
    public ComplexNumber plus(ComplexNumber addend) {
        double sumRe = this.realPart + addend.realPart;
        double sumIm = this.imagPart + addend.imagPart;
        if (Double.isInfinite(sumRe) || Double.isInfinite(sumIm)) {
            String excMsg = "Overflow occurred";
            throw new ArithmeticException(excMsg);
        }
        return new ComplexNumber(sumRe, sumIm);
    }

    // STUB TO FAIL THE FIRST TEST
    @Override
    public ComplexNumber plus(int addend) {
        return new ComplexNumber(0.0, 0.0);
    }

    // STUB TO FAIL THE FIRST TEST
    @Override
    public ComplexNumber negate() {
        return new ComplexNumber(0.0, 0.0);
    }

    @Override
    public ComplexNumber times(ComplexNumber multiplicand) {
        double re = this.realPart * multiplicand.realPart
                - this.imagPart * multiplicand.imagPart;
        double im = this.realPart * multiplicand.imagPart
                + this.imagPart * multiplicand.realPart;
        return new ComplexNumber(re, im);
    }

    // STUB TO FAIL THE FIRST TEST
    @Override
    public ComplexNumber times(int multiplicand) {
        return new ComplexNumber(0.0, 0.0);
    }

    // STUB TO FAIL THE FIRST TEST
    @Override
    public ComplexNumber divides(ComplexNumber divisor) {
        return new ComplexNumber(0.0, 0.0);
    }

    // STUB TO FAIL THE FIRST TEST
    @Override
    public ComplexNumber divides(int divisor) {
        return new ComplexNumber(0.0, 0.0);
    }

    public double abs() {
        double aSquared = this.realPart * this.realPart;
        double bSquared = this.imagPart * this.imagPart;
        return Math.sqrt(aSquared + bSquared);
    }

    public ComplexNumber(double re, double im) {
        this.realPart = re;
        this.imagPart = im;
    }

}
