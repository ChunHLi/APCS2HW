When adding to an empty tree, the node added becomes the root/ If the root is null, set the root equal to the node.
If the root is not null:
and has no children, the node will become one of the root's child.
and has one child, the node will become the other child.
and has two children, the node will become the child of one of the children

When balanced:
adding time = O(logn)

                                                      Value
                                                     /     \
                                                  Tree1   Tree2

PreOrder: VT1T2
InOrder: T1VT2
PostOrder: T1T2V

EX:

                                                        5
                                                     /    \
                                                    8      3
                                                  /   \  /   \
                                                4     6  9    7
                                            
PreOrder: 5,8,4,6,3,9,7
InOrder: 4,8,6,5,9,3,7
PostOrder: 4,6,8,9,7,3,5

void add(value)
node add(root, value)
