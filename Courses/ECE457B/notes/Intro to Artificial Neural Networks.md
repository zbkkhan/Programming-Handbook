---
attachments: [Clipboard_2020-04-10-19-45-51.png, Clipboard_2020-04-10-20-13-08.png, Clipboard_2020-04-10-20-13-37.png, Clipboard_2020-04-10-20-27-30.png, Clipboard_2020-04-10-20-40-06.png, Clipboard_2020-04-10-20-41-13.png, Clipboard_2020-04-10-20-42-22.png, Clipboard_2020-04-10-20-43-22.png]
title: Intro to Artificial Neural Networks
created: '2020-04-10T23:40:32.953Z'
modified: '2020-04-11T00:44:54.356Z'
---

# Intro to Artificial Neural Networks

## ANN Features
![](@attachment/Clipboard_2020-04-10-19-45-51.png)

### Supervised Learning Algorithm
![](@attachment/Clipboard_2020-04-10-20-13-08.png)
1. Compute error between desired and actual outputs
2. Use the error through a learning rule (e.g., gradient descent) to
adjust the network’s connection weights
3. Repeat steps 1 and 2 for input/output patterns to complete one epoch
4. Repeat steps 1 to 3 until maximum number of epochs is reached or an acceptable training error is reached 

### Unsupervised Learning Algorithm
![](@attachment/Clipboard_2020-04-10-20-13-37.png)
1. Training data set is presented at the input layer
2. Output nodes are evaluated through a specific criterion
3. Only weights connected to the winner node are adjusted
4. Repeat steps 1 to 3 until maximum number of epochs is reached or the connection weights reach steady state

> Competitive learning strengths the connection between the incoming pattern at the input layer and the winning output node. 
> The weights connected to each output node can be regarded as the center of the cluster associated to that node. 

### Reinforcement Learning Algorithm

![](@attachment/Clipboard_2020-04-10-20-27-30.png)

> This method of learning attempts to perform weight adjustments through a qualitative and __not a quantitative measure__, much like how humans learn to ride a bike for example

1. Present training input pattern network
2. Qualitatively evaluate system’s reaction to network’s calculated
output 
    - If response is “Good”, the corresponding weights led to that output are strengthened
    - If response is “Bad”, the corresponding weights are weakened

## Fundamentals of Neuro-computing

### Historical Timeline
1. _Late 1940’s_ : McCulloch Pitt Model (by McCulloch and Pitt)
2. _Late 1950’s_ – early 1960’s : Perceptron (by Roseblatt)
3. _Mid 1960’s_ : Adaline (by Widrow)
4. _Mid 1970’s_ : Back Propagation Algorithm - BPL I (by Werbos)
5. _Mid 1980’s_ : BPL II and Multi Layer Perceptron (by Rumelhart and Hinton)

| Model Name | Topology |
| ------ | --- |
| McCulloch Pitt Model | ![](@attachment/Clipboard_2020-04-10-20-40-06.png)   |
| Perceptron      | ![](@attachment/Clipboard_2020-04-10-20-41-13.png)   |
|Adaline | ![](@attachment/Clipboard_2020-04-10-20-42-22.png) |
|Madaline|![](@attachment/Clipboard_2020-04-10-20-43-22.png)|






