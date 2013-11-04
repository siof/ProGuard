/* $Id: NamedClassFileVisitor.java,v 1.4 2002/11/03 13:30:14 eric Exp $
 *
 * ProGuard -- obfuscation and shrinking package for Java class files.
 *
 * Copyright (C) 2002 Eric Lafortune (eric@graphics.cornell.edu)
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package proguard.classfile.visitor;

import proguard.classfile.ClassPool;


/**
 * This class visits ClassFile objects with the given name.
 *
 * @author Eric Lafortune
 */
public class NamedClassFileVisitor implements ClassPoolVisitor
{
    private ClassFileVisitor classFileVisitor;
    private String           name;


    public NamedClassFileVisitor(ClassFileVisitor classFileVisitor,
                                 String           name)
    {
        this.classFileVisitor = classFileVisitor;
        this.name             = name;
    }


    public void visitClassPool(ClassPool classPool)
    {
        try
        {
            classPool.classFileAccept(classFileVisitor, name);
        }
        catch (IllegalArgumentException ex)
        {
        }
    }
}