![rainwatertrap.png](rainwatertrap.png)
<br>
Lets figure out the case of holding water
- At column index 0, we have no left boundary (l=0) but we do have right boundary (r=1), so we can say if one boundary is 0 then we cant trap water. SO could be min(immediate l and r)
- At 2, we see 1 unit of water which follows our logic of min(immediate l and r)
- At 4, Immediate l is 2 and r is 1, we trap 1 water but the water seems to be trapped using the height of l as min and the r=3 at index 8. We also have to take into account the height of the current index which is 1 so it seems to be min(max l,max r) - h(i)
- At 5, we can confirm this.


But notice something in our formula, min(max l,max r) - h(i), at every h(i) we only need the min of l and r, so at each point if we know that max l up till now is smaller than even the current max r we found (and vice versa) we can continue with using that as our min 